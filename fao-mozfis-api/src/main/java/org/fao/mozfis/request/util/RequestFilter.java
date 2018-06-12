package org.fao.mozfis.request.util;

import org.fao.mozfis.core.filter.DomainEntityFilter;

/**
 * Request Filter to be used with JPA Criteria Builder
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public class RequestFilter implements DomainEntityFilter {

	private int year;
	private String regime;
	private String operatorNuit;
	private Long province;
	private Long lastStage;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}

	public String getOperatorNuit() {
		return operatorNuit;
	}

	public void setOperatorNuit(String operatorNuit) {
		this.operatorNuit = operatorNuit;
	}

	public Long getProvince() {
		return province;
	}

	public void setProvince(Long province) {
		this.province = province;
	}

	public Long getLastStage() {
		return lastStage;
	}

	public void setLastStage(Long lastStage) {
		this.lastStage = lastStage;
	}

}