package com.estockinfoservices.stockinfoservices.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="stock_Detials")
@Component
public class StockDetailsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scode;
	private Long companyCode;
	private String stockPrice;
	private LocalDateTime dateTime;
	private Boolean isDeleted;
	
	
	public Long getScode() {
		return scode;
	}
	public void setScode(Long scode) {
		this.scode = scode;
	}
	public Long getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public StockDetailsModel(Long scode, Long companyCode, String stockPrice, LocalDateTime dateTime,
			Boolean isDeleted) {
		super();
		this.scode = scode;
		this.companyCode = companyCode;
		this.stockPrice = stockPrice;
		this.dateTime = dateTime;
		this.isDeleted = isDeleted;
	}
	public StockDetailsModel() {
		super();
	}
	
		
}
