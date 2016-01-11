package com.sloan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sloan.model.Organisation;


@Repository
public class OrganisationDao{

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Organisation> getAllOrganisation() {
		String querystr = "select * from organisation  ";
		Query result =  entityManager.createNativeQuery(querystr,Organisation.class);
		@SuppressWarnings("unchecked")
		List<Organisation> list=	(List<Organisation>)result.getResultList();
		//List<Organisation> dto_list=(ArrayList<Organisation>) entityManager.createNativeQuery(Organisation.class,query).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	public Organisation findOrganisationByName(long organisationId) {
		Organisation list =  entityManager.find(Organisation.class, organisationId);
		System.out.println(list);
		return list;
	}

}
