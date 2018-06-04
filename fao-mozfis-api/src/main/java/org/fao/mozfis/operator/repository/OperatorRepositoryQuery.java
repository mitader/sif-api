package org.fao.mozfis.operator.repository;

import org.fao.mozfis.operator.model.OperatorEntity;
import org.fao.mozfis.operator.util.OperatorFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Extended operations on a repository for Operator domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface OperatorRepositoryQuery {

	/**
	 * Find operators based on suplied filter and paging details
	 * 
	 * @param filter
	 *            the filter
	 * @param pagination
	 *            paging details
	 * @return the operators found
	 */
	public Page<OperatorEntity> findOperators(OperatorFilter filter, Pageable pagination);
}