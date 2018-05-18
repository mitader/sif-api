package org.fao.mozfis.user.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.fao.mozfis.user.model.UserEntity;
import org.fao.mozfis.user.model.UserEntity_;
import org.fao.mozfis.user.model.filter.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

/**
 * Implementation of the UserRepositoryQuery
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public class UserRepositoryImpl extends AbstractRepository<UserEntity, UserFilter> implements UserRepositoryQuery {

	public Page<UserEntity> findUsers(UserFilter filter, Pageable pagination) {

		// TODO: use spring-data Specification, QueryDsl or QueryByExample rather than
		// basic JPA Criteria.
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteria = builder.createQuery(UserEntity.class);
		Root<UserEntity> from = criteria.from(UserEntity.class);

		criteria.where(restrictions(from, filter, builder));

		TypedQuery<UserEntity> query = getEntityManager().createQuery(criteria);
		addPagination(pagination, query);

		return new PageImpl<>(query.getResultList(), pagination, total(filter));
	}

	/**
	 * Create restrictions based on specified filters
	 * 
	 * @param root
	 *            the root of the criteria
	 * @param filter
	 *            the user filter
	 * @param cb
	 *            the criteria builder from the entity manager
	 * @return
	 */
	protected Predicate[] restrictions(Root<UserEntity> root, UserFilter filter, CriteriaBuilder cb) {
		List<Predicate> restrictions = new ArrayList<>();

		if (!StringUtils.isEmpty(filter.getUsername())) {
			restrictions.add(cb.like(root.get(UserEntity_.username), "%" + filter.getUsername() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getFullname())) {
			restrictions.add(cb.like(root.get(UserEntity_.fullname), "%" + filter.getFullname() + "%"));
		}

		return restrictions.toArray(new Predicate[restrictions.size()]);
	}

}