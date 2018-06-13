package org.fao.mozfis.request.repository;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.request.model.ProductCategoryEntity;
import org.fao.mozfis.request.model.ProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represent CRUD operations on a repository for Product Sub Type domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Long> {

	public List<ProductTypeEntity> findByProductCategoryAndStatus(ProductCategoryEntity category, EntityState status);
}