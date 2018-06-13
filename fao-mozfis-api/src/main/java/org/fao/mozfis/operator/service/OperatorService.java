package org.fao.mozfis.operator.service;

import javax.validation.Valid;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.core.service.TransactionalReadOnly;
import org.fao.mozfis.operator.model.OperatorEntity;
import org.fao.mozfis.operator.repository.OperatorRepository;
import org.fao.mozfis.operator.util.OperatorFilter;
import org.fao.mozfis.territory.model.LocalityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Production Service implementation for Operator operations
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@TransactionalReadOnly
public class OperatorService {

	@Autowired
	private OperatorRepository operatorRepository;

	public Page<OperatorEntity> findOperators(OperatorFilter filter, Pageable pagination) {
		return operatorRepository.findOperators(filter, pagination);
	}

	public OperatorEntity findOperator(String nuit) {
		// TODO: internationalize message
		return operatorRepository.findByNuit(nuit).orElseThrow(
				() -> new EmptyResultDataAccessException(String.format("Operador com nuit=%s nao existe", nuit), 1));
	}

	public OperatorEntity createOperator(@Valid OperatorEntity operator) {
		operator.setLocality(new LocalityEntity(operator.getLocalityId()));
		operator.setStatus(EntityState.ACTIVE);
		return operatorRepository.save(operator);
	}

}
