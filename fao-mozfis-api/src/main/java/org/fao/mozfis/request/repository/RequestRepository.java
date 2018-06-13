package org.fao.mozfis.request.repository;

import java.util.List;

import org.fao.mozfis.request.model.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Represent CRUD operations on a repository for Request domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface RequestRepository extends JpaRepository<RequestEntity, Long>, RequestRepositoryQuery {

	/**
	 * Find all requests from givin operator
	 * 
	 * @param nuit
	 *            the nuit's operator
	 * @return the requests found
	 */
	@Query("select r from RequestEntity r inner join r.operator o where o.nuit = :nuit")
	List<RequestEntity> findByOperatorNuit(@Param("nuit") String nuit);
}