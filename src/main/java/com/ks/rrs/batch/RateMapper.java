package com.ks.rrs.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.ks.rrs.jpa.model.Rate;

public class RateMapper implements FieldSetMapper<Rate> {

	@Override
	public Rate mapFieldSet(FieldSet fieldSet) throws BindException {
		// TODO Auto-generated method stub
		Rate rate = new Rate();
		//rate.setFile(fieldSet.);
		return null;
	}

}
