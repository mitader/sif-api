package org.fao.mozfis.forest.repository;

import org.fao.mozfis.forest.model.SpecieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Represent CRUD operations on a repository for Specie domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Repository
public interface SpecieRepository extends JpaRepository<SpecieEntity, Long> {
}