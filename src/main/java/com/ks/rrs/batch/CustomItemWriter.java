package com.ks.rrs.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.ks.rrs.jpa.model.Rate;
import com.ks.rrs.jpa.reository.RateRepository;

public class CustomItemWriter implements ItemWriter<Rate> {
	
	@Autowired
	RateRepository rateRepository;
	
	@Override
	public void write(List<? extends Rate> items) throws Exception {
		// TODO Auto-generated method stub
		for (Rate rate : items) {
			rateRepository.save(rate);
		}
	}

}
