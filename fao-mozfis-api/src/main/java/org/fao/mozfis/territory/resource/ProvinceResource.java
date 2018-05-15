package org.fao.mozfis.territory.resource;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.territory.model.ProvinceEntity;
import org.fao.mozfis.territory.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API to expose REST resources for Provinces
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@RestController
@RequestMapping("/provinces")
public class ProvinceResource {

	@Autowired
	private ProvinceRepository provinceRepository;

	@GetMapping
	public List<ProvinceEntity> findAll() {
		return provinceRepository.findByStatus(EntityState.ACTIVE);
	}

}