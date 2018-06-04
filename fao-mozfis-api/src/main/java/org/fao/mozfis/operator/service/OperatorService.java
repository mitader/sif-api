package org.fao.mozfis.operator.service;

import javax.validation.Valid;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.operator.model.OperatorEntity;
import org.fao.mozfis.operator.repository.OperatorRepository;
import org.fao.mozfis.operator.util.OperatorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Production Service implementation for Operator operations
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Service
public class OperatorService {

	@Autowired
	private OperatorRepository operatorRepository;

	public Page<OperatorEntity> findOperators(OperatorFilter filter, Pageable pagination) {
		return operatorRepository.findOperators(filter, pagination);
	}

	public OperatorEntity findOperator(String nuit) {
		return operatorRepository.findByNuit(nuit);
	}

	public OperatorEntity createOperator(@Valid OperatorEntity operator) {
		operator.setStatus(EntityState.ACTIVE);
		return operatorRepository.save(operator);
	}

}
