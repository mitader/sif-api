package org.fao.mozfis.license.repository;

import java.util.List;

import org.fao.mozfis.license.model.LicenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Represent CRUD operations on a repository for License domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface LicenseRepository extends JpaRepository<LicenseEntity, Long>, LicenseRepositoryQuery {

	/**
	 * Find all requests from givin operator
	 * 
	 * @param nuit
	 *            the nuit's operator
	 * @return the requests found
	 */
	@Query("select l from LicenseEntity l inner join l.operator o where o.nuit = :nuit")
	List<LicenseEntity> findByOperatorNuit(@Param("nuit") String nuit);
}