package com.estockinfoservices.stockinfoservices.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.estockinfoservices.stockinfoservices.dto.StockDetailsModelDTO;
import com.estockinfoservices.stockinfoservices.model.StockDetailsModel;

public interface StockDetailsMapper {
	

	 public static void mapperToDTO(StockDetailsModel stockDetailsModel, StockDetailsModelDTO stockDetailsModelDTO) {
		 stockDetailsModelDTO.setCompanyCode(String.valueOf(stockDetailsModel.getCompanyCode()));
		 stockDetailsModelDTO.setDateTime(stockDetailsModel.getDateTime().toString());
		 stockDetailsModelDTO.setIsDeleted(stockDetailsModel.getIsDeleted());
		 stockDetailsModelDTO.setScode(stockDetailsModel.getScode());
		 stockDetailsModelDTO.setStockPrice(stockDetailsModel.getStockPrice());
	 }
	

	 public static void mapperToModel(StockDetailsModel stockDetailsModel, StockDetailsModelDTO stockDetailsModelDTO) throws Exception{
		 stockDetailsModel.setCompanyCode(Long.parseLong(stockDetailsModelDTO.getCompanyCode()));
		 stockDetailsModel.setIsDeleted(stockDetailsModelDTO.getIsDeleted());
		 stockDetailsModel.setScode(stockDetailsModelDTO.getScode());
		 stockDetailsModel.setStockPrice(stockDetailsModelDTO.getStockPrice());
		 
		 try {
				DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);
				LocalDateTime dateTime = LocalDateTime.parse(stockDetailsModelDTO.getDateTime(), inputFormatter);
				stockDetailsModel.setDateTime(dateTime);
			}catch (Exception ex) {
				throw(ex);
			}
	 }
}

