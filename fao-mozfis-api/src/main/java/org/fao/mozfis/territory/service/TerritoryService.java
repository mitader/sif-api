package org.fao.mozfis.territory.service;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.core.service.TransactionalReadOnly;
import org.fao.mozfis.territory.model.AdministrativePostEntity;
import org.fao.mozfis.territory.model.DistrictEntity;
import org.fao.mozfis.territory.model.LocalityEntity;
import org.fao.mozfis.territory.model.ProvinceEntity;
import org.fao.mozfis.territory.repository.AdministrativePostRepository;
import org.fao.mozfis.territory.repository.DistrictRepository;
import org.fao.mozfis.territory.repository.LocalityRepository;
import org.fao.mozfis.territory.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Production Service implementation for Territory operations
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@TransactionalReadOnly
public class TerritoryService {

	@Autowired
	private ProvinceRepository provinceRepository;

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private AdministrativePostRepository administrativePostRepository;

	@Autowired
	private LocalityRepository localityRepository;

	public List<ProvinceEntity> findProvinces() {
		return provinceRepository.findByStatus(EntityState.ACTIVE);
	}

	public List<DistrictEntity> findDistricts(ProvinceEntity province) {
		return districtRepository.findByProvinceAndStatus(province, EntityState.ACTIVE);
	}

	public List<AdministrativePostEntity> findAdministrativePosts(DistrictEntity district) {
		return administrativePostRepository.findByDistrictAndStatus(district, EntityState.ACTIVE);
	}

	public List<LocalityEntity> findLocalities(AdministrativePostEntity admPost) {
		return localityRepository.findByAdministrativePostAndStatus(admPost, EntityState.ACTIVE);
	}

}