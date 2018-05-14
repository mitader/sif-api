package org.fao.mozfis.user.repository;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represent CRUD operations on a repository for User domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public List<UserEntity> findByStatus(EntityState status);
}