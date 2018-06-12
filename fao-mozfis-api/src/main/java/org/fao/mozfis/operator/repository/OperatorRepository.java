package org.fao.mozfis.operator.repository;

import java.util.Optional;

import org.fao.mozfis.operator.model.OperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represent CRUD operations on a repository for Operator domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Transactional(readOnly = true)
public interface OperatorRepository extends JpaRepository<OperatorEntity, Long>, OperatorRepositoryQuery {

	public Optional<OperatorEntity> findByNuit(String nuit);

}