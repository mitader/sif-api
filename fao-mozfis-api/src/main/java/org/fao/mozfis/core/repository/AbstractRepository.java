package org.fao.mozfis.core.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.fao.mozfis.core.entity.BaseEntity;
import org.fao.mozfis.core.filter.DomainEntityFilter;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * Abstract and global resources to repositories
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public abstract class AbstractRepository<T extends BaseEntity, F extends DomainEntityFilter> {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	protected Class<T> getDomainEntityClass() {
		return (Class<T>) GenericTypeResolver.resolveTypeArguments(getClass(), AbstractRepository.class)[0];
	}

	/**
	 * Create restrictions based on specified filters
	 * 
	 * @param from
	 *            the root entity
	 * 
	 * @param builder
	 *            the criteria builder
	 * 
	 * @param filter
	 *            the domain entity filter
	 * 
	 * @return
	 */
	protected abstract Predicate[] restrictions(Root<T> from, CriteriaBuilder builder, F filter);

	/**
	 * Count total records from the entity T base on the specified filter
	 * 
	 * @param filter
	 *            the filter
	 * @return total records
	 */
	protected long total(F filter) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<T> f = cq.from(getDomainEntityClass());
		cq.where(restrictions(f, cb, filter)).select(cb.count(f));
		return this.entityManager.createQuery(cq).getSingleResult();
	}

	/**
	 * Paginate a query according specified filter and pagination details
	 * 
	 * @param filter
	 *            the filter
	 * @param paging
	 *            the paging details
	 * @return
	 */
	protected Page<T> pagingQuery(F filter, Pageable paging) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(getDomainEntityClass());
		Root<T> from = criteria.from(getDomainEntityClass());
		criteria.where(restrictions(from, builder, filter));

		TypedQuery<T> query = entityManager.createQuery(criteria);
		this.paginate(paging, query);

		return new PageImpl<>(query.getResultList(), paging, total(filter));
	}

	/**
	 * Add pagination to a query based on suplied page details
	 * 
	 * @param pagination
	 *            the pageable to be added
	 * @param query
	 *            the query
	 */
	private void paginate(Pageable pagination, TypedQuery<T> query) {
		int startPosition = pagination.getPageNumber() * pagination.getPageSize();
		query.setMaxResults(pagination.getPageSize());
		query.setFirstResult(startPosition);
	}

}