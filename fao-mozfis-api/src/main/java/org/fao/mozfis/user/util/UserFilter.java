package org.fao.mozfis.user.util;

import org.fao.mozfis.core.filter.DomainEntityFilter;

/**
 * User Filter to be used with JPA Criteria Builder
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public class UserFilter implements DomainEntityFilter {

	private String username;
	private String fullname;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}