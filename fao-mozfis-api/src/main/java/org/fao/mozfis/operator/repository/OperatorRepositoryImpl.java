package org.fao.mozfis.operator.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.fao.mozfis.operator.model.OperatorEntity;
import org.fao.mozfis.operator.model.OperatorEntity_;
import org.fao.mozfis.operator.util.OperatorFilter;
import org.fao.mozfis.user.repository.AbstractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

/**
 * Implementation of the OperatorRepositoryQuery
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public class OperatorRepositoryImpl extends AbstractRepository<OperatorEntity, OperatorFilter>
		implements OperatorRepositoryQuery {

	public Page<OperatorEntity> findOperators(OperatorFilter filter, Pageable paging) {
		return super.pagingQuery(filter, paging);
	}

	protected Predicate[] restrictions(Root<OperatorEntity> from, CriteriaBuilder cb, OperatorFilter filter) {
		List<Predicate> restrictions = new ArrayList<>();

		if (!StringUtils.isEmpty(filter.getNuit())) {
			restrictions.add(cb.like(from.get(OperatorEntity_.nuit), "%" + filter.getNuit() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getName())) {
			restrictions.add(cb.like(from.get(OperatorEntity_.name), "%" + filter.getName() + "%"));
		}

		return restrictions.toArray(new Predicate[restrictions.size()]);
	}

}