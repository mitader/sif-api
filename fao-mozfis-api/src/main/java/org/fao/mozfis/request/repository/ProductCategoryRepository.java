package org.fao.mozfis.request.repository;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.request.model.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represent CRUD operations on a repository for Product Category domain entity
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Transactional(readOnly = true)
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {

	public List<ProductCategoryEntity> findByStatus(EntityState status);
}