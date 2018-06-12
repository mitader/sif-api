package org.fao.mozfis.license.util;

import org.fao.mozfis.core.filter.DomainEntityFilter;

/**
 * License Filter to be used with JPA Criteria Builder
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public class LicenseFilter implements DomainEntityFilter {

	private int year;
	private String licenseNumber;
	private String operatorNuit;
	private Long request;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getOperatorNuit() {
		return operatorNuit;
	}

	public void setOperatorNuit(String operatorNuit) {
		this.operatorNuit = operatorNuit;
	}

	public Long getRequest() {
		return request;
	}

	public void setRequest(Long request) {
		this.request = request;
	}

}