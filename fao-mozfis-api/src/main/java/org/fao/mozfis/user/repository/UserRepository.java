package org.fao.mozfis.user.repository;

import org.fao.mozfis.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represent CRUD operations on a repository for User domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryQuery {

}