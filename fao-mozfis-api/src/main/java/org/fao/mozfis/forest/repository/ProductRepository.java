package org.fao.mozfis.forest.repository;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.forest.model.ProductEntity;
import org.fao.mozfis.license.model.LicenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represent CRUD operations on a repository for Product domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Transactional(readOnly = true)
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	public List<ProductEntity> findByLicenseAndStatus(LicenseEntity license, EntityState state);

}