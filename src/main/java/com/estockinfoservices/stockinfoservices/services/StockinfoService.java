package com.estockinfoservices.stockinfoservices.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estockinfoservices.stockinfoservices.dto.StockDetailsModelDTO;
import com.estockinfoservices.stockinfoservices.mapper.StockDetailsMapper;
import com.estockinfoservices.stockinfoservices.model.StockDetailsModel;
import com.estockinfoservices.stockinfoservices.repository.StockDetailsRepository;

@Service
@Transactional
public class StockinfoService {


	@Autowired
	StockDetailsRepository stockDetailsRepository;


	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	StockDetailsModelDTO stockDetailsModelDTO;

	@Autowired
	StockDetailsModel stockDetailsModel;


	private static final Logger LOGGER=LoggerFactory.getLogger(StockinfoService.class);

	private void sendRequestToEStockMarketApp(StockDetailsModelDTO stockDetailsModelDTO) {
		LOGGER.info("Sending stock details to EStockMarketApp via RabbitMQ");
		LOGGER.info("stockInfoModelDTO: "+stockDetailsModelDTO);
//		rabbitTemplate.convertAndSend("Queue-AddStock", stockDetailsModelDTO);
	}

	private StockDetailsModelDTO getStockInfoByIf(Long id) {

		stockDetailsModel = stockDetailsRepository.getById(id);
		StockDetailsMapper.mapperToDTO(stockDetailsModel, stockDetailsModelDTO);
		return stockDetailsModelDTO;
	}


	public StockDetailsModelDTO addStockDetails(StockDetailsModelDTO stockDetailsModelDTO) {	

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");  
		LocalDateTime now = LocalDateTime.now(); 

		stockDetailsModelDTO.setDateTime(dtf.format(now));
		stockDetailsModelDTO.setIsDeleted(false);

		try {
			StockDetailsMapper.mapperToModel(stockDetailsModel, stockDetailsModelDTO);
		} catch (Exception e) {
			LOGGER.error(e.toString());
		}
		stockDetailsRepository.save(stockDetailsModel);
		LOGGER.info("saved stock details in SQL DB");

		stockDetailsModelDTO = getStockInfoByIf(stockDetailsModel.getScode());
		if(null != stockDetailsModelDTO.getScode()) {
			sendRequestToEStockMarketApp(stockDetailsModelDTO);
		}

		LOGGER.info("stockInfoModelDTO: "+stockDetailsModelDTO);
		return stockDetailsModelDTO;
	}

	public void deleteStocksOfCompany(Long code) {
		stockDetailsRepository.deleteByCompanyCode(code);
	}
}
