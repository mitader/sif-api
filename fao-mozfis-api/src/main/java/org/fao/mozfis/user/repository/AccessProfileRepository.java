package org.fao.mozfis.user.repository;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.user.model.AccessProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represent CRUD operations on a repository for AccessProfile domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface AccessProfileRepository extends JpaRepository<AccessProfileEntity, Long> {

	public List<AccessProfileEntity> findByStatus(EntityState status);
}