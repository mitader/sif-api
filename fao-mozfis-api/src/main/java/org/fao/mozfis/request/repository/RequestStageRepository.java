package org.fao.mozfis.request.repository;

import org.fao.mozfis.request.model.RequestStageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represent CRUD operations on a repository for Request Stage domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Transactional(readOnly = true)
public interface RequestStageRepository extends JpaRepository<RequestStageEntity, Long> {
}