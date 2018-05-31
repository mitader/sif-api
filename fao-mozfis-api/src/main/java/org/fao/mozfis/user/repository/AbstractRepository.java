package org.fao.mozfis.user.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.fao.mozfis.core.entity.BaseEntity;
import org.fao.mozfis.core.filter.DomainEntityFilter;
import org.fao.mozfis.user.model.UserEntity;
import org.springframework.data.domain.Pageable;

/**
 * Abstract and global resources to repositories
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public abstract class AbstractRepository<T extends BaseEntity, F extends DomainEntityFilter> {

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
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
	protected abstract Predicate[] restrictions(Root<UserEntity> root, F filter, CriteriaBuilder cb);

	/**
	 * Add pagination to a query based on suplied page details
	 * 
	 * @param pagination
	 *            the pageable to be added
	 * @param query
	 *            the query
	 */
	protected void addPagination(Pageable pagination, TypedQuery<T> query) {
		int startPosition = pagination.getPageNumber() * pagination.getPageSize();
		query.setMaxResults(pagination.getPageSize());
		query.setFirstResult(startPosition);
	}

	/**
	 * Count total records from the entity T base on the specified filter
	 * 
	 * @param filter
	 *            the filter
	 * @return total records
	 */
	protected long total(F filter) {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		// TODO: use T.class to generalize instead of concrete class
		Root<UserEntity> from = criteria.from(UserEntity.class);

		criteria.where(restrictions(from, filter, builder)).select(builder.count(from));

		return getEntityManager().createQuery(criteria).getSingleResult();
	}

}