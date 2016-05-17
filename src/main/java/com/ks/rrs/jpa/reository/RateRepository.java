package com.ks.rrs.jpa.reository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ks.rrs.jpa.model.Rate;

public interface RateRepository extends PagingAndSortingRepository<Rate, Long>, CustomRateInterface{

	@Query("from Rate")
	List<Rate> getAll();
}
