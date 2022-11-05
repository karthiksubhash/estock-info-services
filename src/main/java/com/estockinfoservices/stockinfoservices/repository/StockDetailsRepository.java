package com.estockinfoservices.stockinfoservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.estockinfoservices.stockinfoservices.model.StockDetailsModel;


public interface StockDetailsRepository extends JpaRepository<StockDetailsModel, Long>  {
	
    @Modifying      // to mark delete or update query
    @Query(value = "DELETE FROM StockDetailsModel sd WHERE sd.companyCode = :code")
    int deleteByCompanyCode(@Param("code") Long code);

}
