package org.fao.mozfis.request.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;
import org.fao.mozfis.operator.model.OperatorEntity;
import org.fao.mozfis.request.util.Purpose;
import org.fao.mozfis.request.util.Regime;
import org.fao.mozfis.territory.model.LocalityEntity;

/**
 * The domain entity for a Request of Forest Exploration
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "request")
public class RequestEntity extends BaseEntity {

	@JoinColumn(name = "operator_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private OperatorEntity operator;

	@NotNull
	@Column(name = "operator_id", nullable = false, insertable = false, updatable = false)
	private Long operatorId;

	@JoinColumn(name = "contract_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ContractEntity contract;

	@NotNull
	@Column(name = "contract_id", nullable = true, insertable = false, updatable = false)
	private Long contractId;

	@JoinColumn(name = "last_stage_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private RequestStageEntity stage;

	// Actually stageId cannot be null, ensure not null through RequestService
	@NotNull
	@Column(name = "last_stage_id", nullable = true, insertable = false, updatable = false)
	private Long stageId;

	@JoinColumn(name = "locality_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private LocalityEntity locality;

	@NotNull
	@Column(name = "locality_id", nullable = false, insertable = false, updatable = false)
	private Long localityId;

	@NotNull
	private BigDecimal area;

	@Column(name = "duration_year")
	private BigDecimal durationInYears;

	@NotNull
	private int year;

	@Enumerated(EnumType.STRING)
	private Regime regime;

	@Enumerated(EnumType.STRING)
	private Purpose purpose;

	@JoinColumn(name = "product_type_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductSubTypeEntity productType;

	// TODO: this is temporarely nullable until all existing requests be
	// regularized.
	@Column(name = "product_type_id", nullable = true, insertable = false, updatable = false)
	private Long productTypeId;

	// TODO: add geo coordinates

	public OperatorEntity getOperator() {
		return operator;
	}

	public void setOperator(OperatorEntity operator) {
		this.operator = operator;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public ContractEntity getContract() {
		return contract;
	}

	public void setContract(ContractEntity contract) {
		this.contract = contract;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public RequestStageEntity getStage() {
		return stage;
	}

	public void setStage(RequestStageEntity stage) {
		this.stage = stage;
	}

	public Long getStageId() {
		return stageId;
	}

	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}

	public LocalityEntity getLocality() {
		return locality;
	}

	public void setLocality(LocalityEntity locality) {
		this.locality = locality;
	}

	public Long getLocalityId() {
		return localityId;
	}

	public void setLocalityId(Long localityId) {
		this.localityId = localityId;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getDurationInYears() {
		return durationInYears;
	}

	public void setDurationInYears(BigDecimal durationInYears) {
		this.durationInYears = durationInYears;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Regime getRegime() {
		return regime;
	}

	public void setRegime(Regime regime) {
		this.regime = regime;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

	public ProductSubTypeEntity getProductType() {
		return productType;
	}

	public void setProductType(ProductSubTypeEntity productType) {
		this.productType = productType;
	}

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((localityId == null) ? 0 : localityId.hashCode());
		result = prime * result + ((operatorId == null) ? 0 : operatorId.hashCode());
		result = prime * result + ((regime == null) ? 0 : regime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestEntity other = (RequestEntity) obj;
		if (localityId == null) {
			if (other.localityId != null)
				return false;
		} else if (!localityId.equals(other.localityId))
			return false;
		if (operatorId == null) {
			if (other.operatorId != null)
				return false;
		} else if (!operatorId.equals(other.operatorId))
			return false;
		return regime == other.regime;
	}

}