package org.fao.mozfis.user.repository;

import org.fao.mozfis.user.model.UserEntity;
import org.fao.mozfis.user.model.filter.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Extended operations on a repository for User domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface UserRepositoryQuery {

	/**
	 * Find users based on suplied filter and paging details
	 * 
	 * @param filter
	 *            the filter
	 * @param pagination
	 *            paging details
	 * @return the users found
	 */
	public Page<UserEntity> findUsers(UserFilter filter, Pageable pagination);
}