package com.ks.rrs.batch;

import java.util.Iterator;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.ks.rrs.config.RawRate;

public class CustomItemReader implements ItemReader<RawRate> {

	private List<RawRate> rawRatesList;

	private Iterator<RawRate> iterator;

	@Override
	public RawRate read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		if (getIterator().hasNext()) {
			return getIterator().next();
		}
		return null;
	}

	public List<RawRate> getRawRatesList() {
		return rawRatesList;
	}

	public void setRawRatesList(List<RawRate> rawRatesList) {
		this.rawRatesList = rawRatesList;
	}

	public Iterator<RawRate> getIterator() {
		return iterator;
	}

	public void setIterator(Iterator<RawRate> iterator) {
		this.iterator = iterator;
	}
}
