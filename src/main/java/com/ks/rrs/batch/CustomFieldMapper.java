package com.ks.rrs.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.ks.rrs.config.RawRate;

public class CustomFieldMapper implements FieldSetMapper {

	String filename;
	
	public CustomFieldMapper(String filename) {
		// TODO Auto-generated constructor stub
		this.filename = filename;
	}

	@Override
	public RawRate mapFieldSet(FieldSet fieldSet) throws BindException {
		// TODO Auto-generated method stub
		RawRate raw = new RawRate();
		raw.setFileName(filename);
		raw.setRawRate(fieldSet.readString(1));
		return raw;
	}

}
