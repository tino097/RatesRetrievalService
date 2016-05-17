package com.ks.rrs.batch;

import org.springframework.batch.item.ItemProcessor;

import com.ks.rrs.config.RawRate;
import com.ks.rrs.jpa.model.Rate;

public class CustomItemProcessor implements ItemProcessor<RawRate, Rate> {

	@Override
	public Rate process(RawRate item) throws Exception {
		// TODO Auto-generated method stub
		Rate rate = new Rate();
		rate.setFile(item.getFileName());
		rate.setValidDate(item.getRawRate().substring(0, 7));
		rate.setRate(Double.parseDouble(item.getRawRate().substring(8, 13)));
		rate.setBuyCurrency(item.getRawRate().substring(14, 17));
		rate.setSellCurrency(item.getRawRate().substring(18, 20));
		return rate;
	}

}
