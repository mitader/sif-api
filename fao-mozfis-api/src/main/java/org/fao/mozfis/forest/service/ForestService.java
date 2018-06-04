package org.fao.mozfis.forest.service;

import org.fao.mozfis.operator.model.OperatorEntity;
import org.fao.mozfis.operator.repository.OperatorRepository;
import org.fao.mozfis.operator.util.OperatorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Production Service implementation for Forest operations
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Service
public class ForestService {

	@Autowired
	private OperatorRepository operatorRepository;

	public Page<OperatorEntity> findRegimes(OperatorFilter filter, Pageable pagination) {
		return operatorRepository.findOperators(filter, pagination);
	}

}
