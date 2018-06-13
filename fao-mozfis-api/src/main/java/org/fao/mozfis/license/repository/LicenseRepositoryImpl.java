package org.fao.mozfis.license.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.fao.mozfis.core.repository.AbstractRepository;
import org.fao.mozfis.license.model.LicenseEntity;
import org.fao.mozfis.license.model.LicenseEntity_;
import org.fao.mozfis.license.util.LicenseFilter;
import org.fao.mozfis.request.util.Regime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

/**
 * Implementation of the LicenseRepositoryQuery
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public class LicenseRepositoryImpl extends AbstractRepository<LicenseEntity, LicenseFilter>
		implements LicenseRepositoryQuery {

	public Page<LicenseEntity> findLicenses(LicenseFilter filter, Pageable paging) {
		return super.pagingQuery(filter, paging);
	}

	protected Predicate[] restrictions(Root<LicenseEntity> from, CriteriaBuilder cb, LicenseFilter filter) {
		List<Predicate> restrictions = new ArrayList<>();

		if (filter.getYear() > 0) {
			restrictions.add(cb.equal(from.get(LicenseEntity_.year), filter.getYear()));
		}

		if (!StringUtils.isEmpty(filter.getLicenseNumber())) {
			restrictions
					.add(cb.equal(from.get(LicenseEntity_.licenseNumber), Regime.valueOf(filter.getLicenseNumber())));
		}

		return restrictions.toArray(new Predicate[restrictions.size()]);
	}

}