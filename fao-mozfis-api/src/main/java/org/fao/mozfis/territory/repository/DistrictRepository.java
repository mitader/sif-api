package org.fao.mozfis.territory.repository;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.territory.model.DistrictEntity;
import org.fao.mozfis.territory.model.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represent CRUD operations on a repository for District domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Transactional(readOnly = true)
public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {

	public List<DistrictEntity> findByProvinceAndStatus(ProvinceEntity province, EntityState status);

}