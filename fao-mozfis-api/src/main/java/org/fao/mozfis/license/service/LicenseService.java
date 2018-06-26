package org.fao.mozfis.license.service;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.core.service.TransactionalModifyOperation;
import org.fao.mozfis.core.service.TransactionalReadOnlyService;
import org.fao.mozfis.forest.model.ProductEntity;
import org.fao.mozfis.forest.model.SpecieEntity;
import org.fao.mozfis.forest.repository.ProductRepository;
import org.fao.mozfis.license.model.LicenseEntity;
import org.fao.mozfis.license.repository.LicenseRepository;
import org.fao.mozfis.license.util.LicenseFilter;
import org.fao.mozfis.operator.model.OperatorEntity;
import org.fao.mozfis.request.model.RequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for License operations
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@TransactionalReadOnlyService
public class LicenseService {

	@Autowired
	private LicenseRepository licenseRepository;

	@Autowired
	private ProductRepository productRepository;

	public Page<LicenseEntity> findLicenses(LicenseFilter filter, Pageable pagination) {
		return licenseRepository.findLicenses(filter, pagination);
	}

	public List<LicenseEntity> findLicenses(String nuit) {
		return licenseRepository.findByOperatorNuit(nuit);
	}

	/**
	 * Load an existing license into the repository.
	 * 
	 * @deprecated This is only to be used for initial loading purpose and will be
	 *             removed after all existing licenses be loaded
	 * 
	 * @param license
	 *            the license to be loaded
	 * @return
	 */
	@Deprecated
	@TransactionalModifyOperation
	public LicenseEntity createExistingLicense(LicenseEntity license) {

		List<ProductEntity> products = license.getProducts();

		// create the license
		license.setId(null);
		license.setStatus(EntityState.ACTIVE);
		license.setOperator(new OperatorEntity(license.getOperatorId()));
		license.setRequest(new RequestEntity(license.getRequestId()));
		licenseRepository.save(license);

		// add products
		products.forEach(p -> {
			p.setStatus(EntityState.ACTIVE);
			p.setLicense(license);
			p.setSpecie(new SpecieEntity(p.getSpecieId()));
		});

		productRepository.saveAll(products);

		return license;
	}

}