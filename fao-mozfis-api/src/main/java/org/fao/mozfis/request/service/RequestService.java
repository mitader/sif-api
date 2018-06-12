package org.fao.mozfis.request.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.core.service.TransactionalReadOnly;
import org.fao.mozfis.operator.model.OperatorEntity;
import org.fao.mozfis.operator.repository.OperatorRepository;
import org.fao.mozfis.request.model.ContractEntity;
import org.fao.mozfis.request.model.RequestEntity;
import org.fao.mozfis.request.model.RequestStageEntity;
import org.fao.mozfis.request.model.StageEntity;
import org.fao.mozfis.request.repository.ContractRepository;
import org.fao.mozfis.request.repository.RequestRepository;
import org.fao.mozfis.request.repository.RequestStageRepository;
import org.fao.mozfis.request.util.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service implementation for Resquest operations
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@TransactionalReadOnly
public class RequestService {

	@Autowired
	private ContractRepository contractRepository;

	@Autowired
	private OperatorRepository operatorRepository;

	@Autowired
	private RequestStageRepository requestStageRepository;

	@Autowired
	private RequestRepository requestRepository;

	public Page<RequestEntity> findRequests(RequestFilter filter, Pageable pagination) {
		return requestRepository.findRequests(filter, pagination);
	}

	public List<RequestEntity> findRequests(String nuit) {
		return requestRepository.findByOperatorNuit(nuit);
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { DataIntegrityViolationException.class })
	public RequestEntity createExistingRequest(@Valid RequestEntity request) {

		// operator
		Optional<OperatorEntity> operator = operatorRepository.findByNuit(request.getOperator().getNuit());

		// create contract
		ContractEntity contract = request.getContract();
		contract.setStatus(EntityState.ACTIVE);
		contractRepository.save(contract);

		// create request
		request.setOperator(operator.isPresent() ? operator.get() : null);
		request.setStatus(EntityState.ACTIVE);
		RequestEntity saved = requestRepository.save(request);

		// create approved stage
		RequestStageEntity stage = new RequestStageEntity(new StageEntity(StageEntity.APPROVED));
		stage.setStatus(EntityState.ACTIVE);
		stage.setRequest(request);
		requestStageRepository.save(stage);

		// update last stage to the request
		request.setLastStage(stage);

		return saved;
	}

}