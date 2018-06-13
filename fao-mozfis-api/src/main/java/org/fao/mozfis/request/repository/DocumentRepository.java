package org.fao.mozfis.request.repository;

import org.fao.mozfis.request.model.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represent CRUD operations on a repository for Document domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
}