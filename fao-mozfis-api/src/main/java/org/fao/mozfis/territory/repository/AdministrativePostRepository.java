package org.fao.mozfis.territory.repository;

import org.fao.mozfis.territory.model.AdministrativePostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represent CRUD operations on a repository for Administrative Post domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Transactional(readOnly = true)
public interface AdministrativePostRepository extends JpaRepository<AdministrativePostEntity, Long> {

}