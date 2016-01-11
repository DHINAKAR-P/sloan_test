package com.sloan.service;

import java.util.List;

import com.sloan.model.Organisation;

public interface OrganisationService {

	public List<Organisation> getAllOrganisation();
	
	public Organisation findOrganisationByName(long organisationId);
	
}
