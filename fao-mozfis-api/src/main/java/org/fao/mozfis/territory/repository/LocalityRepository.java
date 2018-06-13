package org.fao.mozfis.territory.repository;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.territory.model.AdministrativePostEntity;
import org.fao.mozfis.territory.model.LocalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represent CRUD operations on a repository for Locality domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface LocalityRepository extends JpaRepository<LocalityEntity, Long> {

	public List<LocalityEntity> findByAdministrativePostAndStatus(AdministrativePostEntity admPost, EntityState status);

}