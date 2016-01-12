package com.sloan.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.dao.OrganisationDao;
import com.sloan.model.Organisation;
import com.sloan.service.OrganisationService;


@Service("organisationServiceImpl")
@Transactional
public class OrganisationServiceImpl implements OrganisationService{

	@Autowired
	private OrganisationDao organisationDao;  
	
	@Override
	public List<Organisation> getAllOrganisation() {
		List<Organisation> orgList = organisationDao.getAllOrganisation();
		return orgList;
	}

	@Override
	public Organisation findOrganisationByName(long organisationId) {
		// TODO Auto-generated method stub
		Organisation orgListByName = organisationDao.findOrganisationByName(organisationId);
		return orgListByName;
	}

}
