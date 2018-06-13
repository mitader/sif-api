package org.fao.mozfis.request.repository;

import org.fao.mozfis.request.model.RequestStageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represent CRUD operations on a repository for Request Stage domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface RequestStageRepository extends JpaRepository<RequestStageEntity, Long> {
}