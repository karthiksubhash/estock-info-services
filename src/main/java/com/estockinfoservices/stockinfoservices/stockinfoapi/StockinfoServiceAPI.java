package com.estockinfoservices.stockinfoservices.stockinfoapi;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estockinfoservices.stockinfoservices.dto.StockDetailsModelDTO;
import com.estockinfoservices.stockinfoservices.services.StockinfoService;

@RestController
public class StockinfoServiceAPI {
	
	@Autowired
	StockinfoService stockinfoService;
	

	@GetMapping("/hi")
	public StockDetailsModelDTO getstockInfo() {
		StockDetailsModelDTO temp= new StockDetailsModelDTO();
		temp.setScode((long)1);
		temp.setCompanyCode("44");
		temp.setStockPrice("130");
		return temp;
	}
	
	@PostMapping("/stock/add")
	public StockDetailsModelDTO addStockDetails(@Valid @RequestBody StockDetailsModelDTO stockDetailsModelDTO ) {
		return stockinfoService.addStockDetails(stockDetailsModelDTO);
	}
	
	
}
