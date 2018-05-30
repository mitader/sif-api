package org.fao.mozfis.request.repository;

import org.fao.mozfis.request.model.StageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represent CRUD operations on a repository for Stage domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Transactional(readOnly = true)
public interface StageRepository extends JpaRepository<StageEntity, Long> {
}