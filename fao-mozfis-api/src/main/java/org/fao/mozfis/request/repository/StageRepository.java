package org.fao.mozfis.request.repository;

import org.fao.mozfis.request.model.StageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represent CRUD operations on a repository for Stage domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface StageRepository extends JpaRepository<StageEntity, Long> {
}