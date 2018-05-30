package org.fao.mozfis.territory.repository;

import org.fao.mozfis.territory.model.LocalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represent CRUD operations on a repository for Locality domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Transactional(readOnly = true)
public interface LocalityRepository extends JpaRepository<LocalityEntity, Long> {

}