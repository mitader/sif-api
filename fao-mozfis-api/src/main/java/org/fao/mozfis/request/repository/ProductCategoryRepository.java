package org.fao.mozfis.request.repository;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.request.model.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represent CRUD operations on a repository for Product Category domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {

	public List<ProductCategoryEntity> findByStatus(EntityState status);
}