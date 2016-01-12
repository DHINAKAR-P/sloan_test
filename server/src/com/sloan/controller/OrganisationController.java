package com.sloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sloan.model.Organisation;
import com.sloan.service.impl.OrganisationServiceImpl;

@Controller
@RequestMapping("/organization")
public class OrganisationController {

	@Autowired
	private OrganisationServiceImpl orgserviceimpl;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllOrg/", headers = "Accept=application/json")
	@ResponseBody
	public List<Organisation> getAllOrganisation() {
		List<Organisation> organisationList =orgserviceimpl.getAllOrganisation();
		return organisationList;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOrganisationById/", headers = "Accept=application/json")
	@ResponseBody
	public Organisation findOrganisationByName(@RequestParam("organisationId") long organisationId) {
		Organisation orgListForName = orgserviceimpl.findOrganisationByName(organisationId);
		System.out.println(orgListForName);
		return orgListForName;
	}

}
