package org.fao.mozfis.territory.repository;

import org.fao.mozfis.territory.model.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represent CRUD operations on a repository for District domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Transactional(readOnly = true)
public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {

}