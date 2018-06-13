package org.fao.mozfis.operator.repository;

import java.util.Optional;

import org.fao.mozfis.operator.model.OperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represent CRUD operations on a repository for Operator domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface OperatorRepository extends JpaRepository<OperatorEntity, Long>, OperatorRepositoryQuery {

	public Optional<OperatorEntity> findByNuit(String nuit);

}