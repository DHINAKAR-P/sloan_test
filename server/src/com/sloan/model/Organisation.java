package com.sloan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "organisation")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Organisation {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "organisation_name")
	private String organisationName;

	@Column(name = "organisation_location")
	private String organisationLocation;

	@Column(name = "organisation_phonenumber")
	private String organisationPhoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getOrganisationLocation() {
		return organisationLocation;
	}

	public void setOrganisationLocation(String organisationLocation) {
		this.organisationLocation = organisationLocation;
	}

	public String getOrganisationPhoneNumber() {
		return organisationPhoneNumber;
	}

	public void setOrganisationPhoneNumber(String organisationPhoneNumber) {
		this.organisationPhoneNumber = organisationPhoneNumber;
	}
	
	

}
