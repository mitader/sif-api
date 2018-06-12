package org.fao.mozfis.license.repository;

import org.fao.mozfis.license.model.LicenseEntity;
import org.fao.mozfis.license.util.LicenseFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Extended operations on a repository for License domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface LicenseRepositoryQuery {

	/**
	 * Find operators based on suplied filter and paging details
	 * 
	 * @param filter
	 *            the filter
	 * @param pagination
	 *            paging details
	 * @return the operators found
	 */
	public Page<LicenseEntity> findLicenses(LicenseFilter filter, Pageable pagination);
}