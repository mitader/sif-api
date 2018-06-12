package org.fao.mozfis.license.service;

import java.util.List;
import java.util.Optional;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.core.service.TransactionalReadOnly;
import org.fao.mozfis.core.service.TransactionalModify;
import org.fao.mozfis.forest.model.ProductEntity;
import org.fao.mozfis.forest.repository.ProductRepository;
import org.fao.mozfis.license.model.LicenseEntity;
import org.fao.mozfis.license.repository.LicenseRepository;
import org.fao.mozfis.license.util.LicenseFilter;
import org.fao.mozfis.operator.model.OperatorEntity;
import org.fao.mozfis.operator.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service implementation for License operations
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@TransactionalReadOnly
public class LicenseService {

	@Autowired
	private LicenseRepository licenseRepository;

	@Autowired
	private OperatorRepository operatorRepository;

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
	@TransactionalModify
	public LicenseEntity createExistingLicense(LicenseEntity license) {

		List<ProductEntity> products = license.getProducts();

		// operator
		Optional<OperatorEntity> operator = operatorRepository.findByNuit(license.getOperator().getNuit());

		// create the license
		license.setStatus(EntityState.ACTIVE);
		license.setOperator(operator.isPresent() ? operator.get() : null);
		licenseRepository.save(license);

		// add products
		products.forEach(p -> {
			p.setStatus(EntityState.ACTIVE);
			p.setLicense(license);
		});

		productRepository.saveAll(products);

		return license;
	}

}