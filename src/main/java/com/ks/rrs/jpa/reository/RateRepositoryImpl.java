package com.ks.rrs.jpa.reository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ks.rrs.jpa.model.Rate;

public class RateRepositoryImpl implements CustomRateInterface {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Rate> getAllRatesSortedByDate(Date date) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Rates r order by ? asc").setParameter(1, date);
		List<Rate> sortedRates = query.getResultList();
		return sortedRates;
	}

}
