package org.fao.mozfis.license.repository;

import org.fao.mozfis.license.model.LicenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represent CRUD operations on a repository for License domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Transactional(readOnly = true)
public interface LicenseRepository extends JpaRepository<LicenseEntity, Long> {
}