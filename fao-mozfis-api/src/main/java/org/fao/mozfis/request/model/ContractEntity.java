package org.fao.mozfis.request.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;

/**
 * The domain entity for a Contract
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "contract", uniqueConstraints = { @UniqueConstraint(columnNames = "contract_number") })
public class ContractEntity extends BaseEntity {

	@NotNull
	@Column(name = "contract_number")
	private String contractNumber;

	@Column(name = "signature_date")
	private LocalDateTime signatureDate;

	@Column(name = "approval_date")
	private LocalDateTime approvalDate;

	@Column(name = "revision_date")
	private LocalDateTime revisionDate;

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public LocalDateTime getSignatureDate() {
		return signatureDate;
	}

	public void setSignatureDate(LocalDateTime signatureDate) {
		this.signatureDate = signatureDate;
	}

	public LocalDateTime getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(LocalDateTime approvalDate) {
		this.approvalDate = approvalDate;
	}

	public LocalDateTime getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(LocalDateTime revisionDate) {
		this.revisionDate = revisionDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contractNumber == null) ? 0 : contractNumber.hashCode());
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
		ContractEntity other = (ContractEntity) obj;
		if (contractNumber == null) {
			if (other.contractNumber != null)
				return false;
		} else if (!contractNumber.equals(other.contractNumber))
			return false;
		return true;
	}

}