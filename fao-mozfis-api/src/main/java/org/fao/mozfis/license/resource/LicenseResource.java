package org.fao.mozfis.license.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.fao.mozfis.core.event.CreateResourceEvent;
import org.fao.mozfis.core.filter.Views;
import org.fao.mozfis.license.model.LicenseEntity;
import org.fao.mozfis.license.service.LicenseService;
import org.fao.mozfis.license.util.LicenseFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * API to expose REST resources for Licenses
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@RestController
@RequestMapping("/licenses")
public class LicenseResource {

	@Autowired
	private LicenseService licenseService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@JsonView(Views.Summary.class)
	@GetMapping
	public Page<LicenseEntity> findLicenses(LicenseFilter filter, Pageable pagination) {
		return licenseService.findLicenses(filter, pagination);
	}

	@JsonView(Views.Summary.class)
	@GetMapping("/{nuit}")
	public List<LicenseEntity> findLicenses(@PathVariable String nuit) {
		return licenseService.findLicenses(nuit);
	}

	@JsonView(Views.Summary.class)
	@PostMapping("/existing")
	public ResponseEntity<LicenseEntity> save(@Valid @RequestBody LicenseEntity license, HttpServletResponse response) {
		LicenseEntity created = licenseService.createExistingLicense(license);
		publisher.publishEvent(new CreateResourceEvent(this, response, created.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}

}