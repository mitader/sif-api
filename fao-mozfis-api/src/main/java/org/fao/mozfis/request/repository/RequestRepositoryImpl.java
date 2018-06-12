package org.fao.mozfis.request.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.fao.mozfis.request.model.RequestEntity;
import org.fao.mozfis.request.model.RequestEntity_;
import org.fao.mozfis.request.util.Regime;
import org.fao.mozfis.request.util.RequestFilter;
import org.fao.mozfis.user.repository.AbstractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

/**
 * Implementation of the RequestRepositoryQuery
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public class RequestRepositoryImpl extends AbstractRepository<RequestEntity, RequestFilter>
		implements RequestRepositoryQuery {

	public Page<RequestEntity> findRequests(RequestFilter filter, Pageable paging) {
		return super.pagingQuery(filter, paging);
	}

	protected Predicate[] restrictions(Root<RequestEntity> from, CriteriaBuilder cb, RequestFilter filter) {
		List<Predicate> restrictions = new ArrayList<>();

		if (filter.getYear() > 0) {
			restrictions.add(cb.equal(from.get(RequestEntity_.year), filter.getYear()));
		}

		if (!StringUtils.isEmpty(filter.getRegime())) {
			restrictions.add(cb.equal(from.get(RequestEntity_.regime), Regime.valueOf(filter.getRegime())));
		}

		// TODO implement me!
		// if (filter.getStage()!=null) {
		// restrictions.add(cb.equal(from.get(RequestEntity_.stage), new
		// RequestStageEntity(filter.getStage())));
		// }

		// if (!StringUtils.isEmpty(filter.getOperatorNuit())) {
		// restrictions.add(cb.equal(from.get(RequestEntity_.operatorNuit),
		// filter.getOperatorNuit()));
		// }

		// if (filter.getProvince() != null) {
		// restrictions.add(cb.equal(from.get(RequestEntity_.province),
		// filter.getRegime()));
		// }

		return restrictions.toArray(new Predicate[restrictions.size()]);
	}

}