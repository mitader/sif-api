package org.fao.mozfis.territory.repository;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.territory.model.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represent CRUD operations on a repository for Province domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {

	public List<ProvinceEntity> findByStatus(EntityState status);
}