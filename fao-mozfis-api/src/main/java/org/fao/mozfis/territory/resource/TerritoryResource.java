package org.fao.mozfis.territory.resource;

import java.util.List;

import org.fao.mozfis.territory.model.AdministrativePostEntity;
import org.fao.mozfis.territory.model.DistrictEntity;
import org.fao.mozfis.territory.model.LocalityEntity;
import org.fao.mozfis.territory.model.ProvinceEntity;
import org.fao.mozfis.territory.service.TerritoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API to expose REST resources for Provinces
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@RestController
@RequestMapping("/territory")
public class TerritoryResource {

	@Autowired
	private TerritoryService territoryService;

	@GetMapping("provinces")
	public List<ProvinceEntity> findProvinces() {
		return territoryService.findProvinces();
	}

	@GetMapping("districts/{province}")
	public List<DistrictEntity> findDistricts(@PathVariable Long province) {
		return territoryService.findDistricts(new ProvinceEntity(province));
	}

	@GetMapping("adm-posts/{district}")
	public List<AdministrativePostEntity> findAdministrativePosts(@PathVariable Long district) {
		return territoryService.findAdministrativePosts(new DistrictEntity(district));
	}

	@GetMapping("localities/{admPost}")
	public List<LocalityEntity> findLocalities(@PathVariable Long admPost) {
		return territoryService.findLocalities(new AdministrativePostEntity(admPost));
	}

}