package org.fao.mozfis.user.resource;

import java.util.List;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.user.model.AccessProfileEntity;
import org.fao.mozfis.user.repository.AccessProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API to expose REST resources for AccessProfiles
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@RestController
@RequestMapping("/accessprofiles")
public class AccessProfileResource {

	@Autowired
	private AccessProfileRepository accessProfileRepository;

	@GetMapping
	public List<AccessProfileEntity> findAll() {
		return accessProfileRepository.findByStatus(EntityState.active);
	}

}