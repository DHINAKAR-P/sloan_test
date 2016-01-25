package com.sloan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sloan.model.Organisation;
import com.sloan.model.baseOrganisation;

@Repository
public class OrganisationDao {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<baseOrganisation> getAllOrganisation() {
		String querystr = "select * from base_organisation";
		Query result = entityManager.createNativeQuery(querystr, baseOrganisation.class);
		List<baseOrganisation> list = (List<baseOrganisation>) result.getResultList();
		return list;
	}

	public Organisation findOrganisationByName(long organisationId) {
		Organisation list = entityManager.find(Organisation.class, organisationId);
		System.out.println(list);
		return list;
	}

	public Organisation createOrganisation(Organisation organisation) {
		Organisation org=new Organisation();
		String id=organisation.getId().toString();//Base organisation object oly come here from jSon
		org.setBase_organisation_id(id);
		org.setOrganisationLocation(organisation.getOrganisationLocation());
		org.setOrganisationName(organisation.getOrganisationName());
		org.setOrganisationPhoneNumber(organisation.getOrganisationPhoneNumber());
		entityManager.persist(organisation);
		entityManager.flush();
		return organisation;
	}

}
