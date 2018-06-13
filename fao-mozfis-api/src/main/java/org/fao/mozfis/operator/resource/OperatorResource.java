package org.fao.mozfis.operator.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.fao.mozfis.core.event.CreateResourceEvent;
import org.fao.mozfis.core.filter.Views;
import org.fao.mozfis.operator.model.OperatorEntity;
import org.fao.mozfis.operator.service.OperatorService;
import org.fao.mozfis.operator.util.OperatorFilter;
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
 * API to expose REST resources for Operators
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@RestController
@RequestMapping("/operators")
public class OperatorResource {

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@JsonView(Views.Summary.class)
	@GetMapping
	public Page<OperatorEntity> findOperators(OperatorFilter filter, Pageable pagination) {
		return operatorService.findOperators(filter, pagination);
	}

	@JsonView(Views.Summary.class)
	@GetMapping("/{nuit}")
	public ResponseEntity<OperatorEntity> findOperator(@Valid @PathVariable String nuit) {
		OperatorEntity operator = operatorService.findOperator(nuit);
		return operator != null ? ResponseEntity.ok(operator) : ResponseEntity.notFound().build();
	}

	@JsonView(Views.Summary.class)
	@PostMapping
	public ResponseEntity<OperatorEntity> save(@Valid @RequestBody OperatorEntity operator,
			HttpServletResponse response) {
		OperatorEntity created = operatorService.createOperator(operator);
		publisher.publishEvent(new CreateResourceEvent(this, response, created.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}

}