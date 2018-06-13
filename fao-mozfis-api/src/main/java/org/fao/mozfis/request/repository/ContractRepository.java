package org.fao.mozfis.request.repository;

import org.fao.mozfis.request.model.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represent CRUD operations on a repository for Contract domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {
}