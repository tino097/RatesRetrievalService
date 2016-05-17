package com.ks.rrs.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ks.rrs.jpa.model.Rate;
import com.ks.rrs.jpa.reository.RateRepository;

@Service
@Path("/rates")
public class RatesService {

	@Autowired
	private RateRepository rateRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public List<Rate> getAll() {
	
		return rateRepository.getAll();

	}

}
