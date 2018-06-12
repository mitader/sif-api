package org.fao.mozfis.request.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.fao.mozfis.core.event.CreateResourceEvent;
import org.fao.mozfis.core.filter.Views;
import org.fao.mozfis.request.model.RequestEntity;
import org.fao.mozfis.request.service.RequestService;
import org.fao.mozfis.request.util.RequestFilter;
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
 * API to expose REST resources for Requests
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@RestController
@RequestMapping("/requests")
public class RequestResource {

	@Autowired
	private RequestService requestService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@JsonView(Views.Summary.class)
	@GetMapping
	public Page<RequestEntity> findRequests(RequestFilter filter, Pageable pagination) {
		return requestService.findRequests(filter, pagination);
	}

	@JsonView(Views.Summary.class)
	@GetMapping("/{nuit}")
	public List<RequestEntity> findRequests(@PathVariable String nuit) {
		return requestService.findRequests(nuit);
	}

	@JsonView(Views.Summary.class)
	@PostMapping("/existing")
	public ResponseEntity<RequestEntity> save(@Valid @RequestBody RequestEntity request, HttpServletResponse response) {
		RequestEntity created = requestService.createExistingRequest(request);
		publisher.publishEvent(new CreateResourceEvent(this, response, created.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}

}