package com.estockinfoservices.stockinfoservices.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class StockDetailsModelDTO {

	
	private Long scode;
	
	@NotBlank(message = "companyCode is mandatory to fill !!")
	private String companyCode;
	@NotBlank(message = "stockPrice is mandatory to fill !!")
	private String stockPrice;
	
	private String dateTime;
	private Boolean isDeleted; 
	
	public Long getScode() {
		return scode;
	}
	public void setScode(Long scode) {
		this.scode = scode;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public StockDetailsModelDTO(Long scode, String companyCode, String stockPrice, String dateTime,
			Boolean isDeleted) {
		super();
		this.scode = scode;
		this.companyCode = companyCode;
		this.stockPrice = stockPrice;
		this.dateTime = dateTime;
		this.isDeleted = isDeleted;
	}
	public StockDetailsModelDTO() {
		super();
	}
	
}
