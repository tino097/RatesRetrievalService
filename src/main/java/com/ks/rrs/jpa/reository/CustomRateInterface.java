package com.ks.rrs.jpa.reository;

import java.util.Date;
import java.util.List;

import com.ks.rrs.jpa.model.Rate;

public interface CustomRateInterface {

	List<Rate> getAllRatesSortedByDate(Date date);
}
