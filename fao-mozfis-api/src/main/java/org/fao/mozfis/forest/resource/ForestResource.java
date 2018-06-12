package org.fao.mozfis.forest.resource;

import java.util.Arrays;
import java.util.List;

import org.fao.mozfis.core.filter.Views;
import org.fao.mozfis.forest.model.ProductEntity;
import org.fao.mozfis.forest.service.ForestService;
import org.fao.mozfis.license.model.LicenseEntity;
import org.fao.mozfis.request.model.ProductCategoryEntity;
import org.fao.mozfis.request.model.ProductTypeEntity;
import org.fao.mozfis.request.util.Purpose;
import org.fao.mozfis.request.util.Regime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * API to expose REST resources for Provinces
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@RestController
@RequestMapping("/forest")
public class ForestResource {

	@Autowired
	private ForestService forestService;

	@GetMapping("regimes")
	public List<Regime> getRegimes() {
		return Arrays.asList(Regime.values());
	}

	@GetMapping("purposes")
	public List<Purpose> getPurposes() {
		return Arrays.asList(Purpose.values());
	}

	@GetMapping("product-categories")
	public List<ProductCategoryEntity> getProductCategories() {
		return forestService.findProductCategories();
	}

	@JsonView(Views.Summary.class)
	@GetMapping("product-types/{category}")
	public List<ProductTypeEntity> getProductTypes(@PathVariable Long category) {
		return forestService.findProductTypes(new ProductCategoryEntity(category));
	}

	@JsonView(Views.Summary.class)
	@GetMapping("products/{license}")
	public List<ProductEntity> findProducts(@PathVariable Long license) {
		return forestService.findProducts(new LicenseEntity(license));
	}

}