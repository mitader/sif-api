package org.fao.mozfis.operator.util;

import org.fao.mozfis.core.filter.DomainEntityFilter;

/**
 * Operator Filter to be used with JPA Criteria Builder
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public class OperatorFilter implements DomainEntityFilter {

	private String nuit;
	private String name;

	public String getNuit() {
		return nuit;
	}

	public void setNuit(String nuit) {
		this.nuit = nuit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}