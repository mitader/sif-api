package org.fao.mozfis.user.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.fao.mozfis.core.repository.AbstractRepository;
import org.fao.mozfis.user.model.UserEntity;
import org.fao.mozfis.user.model.UserEntity_;
import org.fao.mozfis.user.util.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

/**
 * Implementation of the UserRepositoryQuery
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public class UserRepositoryImpl extends AbstractRepository<UserEntity, UserFilter> implements UserRepositoryQuery {

	public Page<UserEntity> findUsers(UserFilter filter, Pageable pagination) {
		return pagingQuery(filter, pagination);
	}

	/**
	 * Create restrictions based on specified filters
	 * 
	 * @param filter
	 *            the user filter
	 * @return
	 */
	@Override
	protected Predicate[] restrictions(Root<UserEntity> from, CriteriaBuilder cb, UserFilter filter) {

		List<Predicate> restrictions = new ArrayList<>();

		if (!StringUtils.isEmpty(filter.getUsername())) {
			restrictions.add(cb.like(from.get(UserEntity_.username), "%" + filter.getUsername() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getFullname())) {
			restrictions.add(cb.like(from.get(UserEntity_.fullname), "%" + filter.getFullname() + "%"));
		}

		return restrictions.toArray(new Predicate[restrictions.size()]);
	}

}