package org.fao.mozfis.request.repository;

import org.fao.mozfis.request.model.RequestEntity;
import org.fao.mozfis.request.util.RequestFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Extended operations on a repository for Request domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface RequestRepositoryQuery {

	/**
	 * Find operators based on suplied filter and paging details
	 * 
	 * @param filter
	 *            the filter
	 * @param pagination
	 *            paging details
	 * @return the operators found
	 */
	public Page<RequestEntity> findRequests(RequestFilter filter, Pageable pagination);
}