package org.fao.mozfis.forest.service;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.core.service.TransactionalReadOnlyService;
import org.fao.mozfis.forest.model.ProductEntity;
import org.fao.mozfis.forest.repository.ProductRepository;
import org.fao.mozfis.license.model.LicenseEntity;
import org.fao.mozfis.request.model.ProductCategoryEntity;
import org.fao.mozfis.request.model.ProductTypeEntity;
import org.fao.mozfis.request.repository.ProductCategoryRepository;
import org.fao.mozfis.request.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Production Service implementation for Forest operations
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@TransactionalReadOnlyService
public class ForestService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Autowired
	private ProductRepository productRepository;

	public List<ProductCategoryEntity> findProductCategories() {
		return productCategoryRepository.findByStatus(EntityState.ACTIVE);
	}

	public List<ProductTypeEntity> findProductTypes(ProductCategoryEntity category) {
		return productTypeRepository.findByProductCategoryAndStatus(category, EntityState.ACTIVE);
	}

	public List<ProductEntity> findProducts(LicenseEntity license) {
		return productRepository.findByLicenseAndStatus(license, EntityState.ACTIVE);
	}

}
