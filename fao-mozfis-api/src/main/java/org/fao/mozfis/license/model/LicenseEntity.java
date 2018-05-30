package org.fao.mozfis.license.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;
import org.fao.mozfis.operator.model.OperatorEntity;
import org.fao.mozfis.request.model.RequestEntity;

/**
 * The domain entity for a License
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "license", uniqueConstraints = { @UniqueConstraint(columnNames = "number") })
public class LicenseEntity extends BaseEntity {

	@NotNull
	private String number;

	@NotNull
	private int year;

	private String description;

	@JoinColumn(name = "request_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private RequestEntity request;

	@NotNull
	@Column(name = "request_id", nullable = false, insertable = false, updatable = false)
	private Long requestId;

	@JoinColumn(name = "operator_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private OperatorEntity operator;

	@NotNull
	@Column(name = "operator_id", nullable = false, insertable = false, updatable = false)
	private Long operatorId;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RequestEntity getRequest() {
		return request;
	}

	public void setRequest(RequestEntity request) {
		this.request = request;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		LicenseEntity other = (LicenseEntity) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

}