package org.fao.mozfis.territory.repository;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.territory.model.AdministrativePostEntity;
import org.fao.mozfis.territory.model.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represent CRUD operations on a repository for Administrative Post domain
 * entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface AdministrativePostRepository extends JpaRepository<AdministrativePostEntity, Long> {

	public List<AdministrativePostEntity> findByDistrictAndStatus(DistrictEntity district, EntityState status);
}