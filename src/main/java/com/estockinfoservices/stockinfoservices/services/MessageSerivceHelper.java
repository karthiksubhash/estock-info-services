package com.estockinfoservices.stockinfoservices.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSerivceHelper {
	
	@Autowired
	StockinfoService stockinfoService;
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(MessageSerivceHelper.class);
	
	@RabbitListener(queues = "Queue-DeleteStocks")
	public void getDeleteCompnayCode(Long code) {
		LOGGER.info("Queue-DeleteStocks for company :"+ code);
		stockinfoService.deleteStocksOfCompany(code);
	}

}
