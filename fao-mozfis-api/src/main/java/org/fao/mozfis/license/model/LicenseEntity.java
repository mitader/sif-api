package org.fao.mozfis.license.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.fao.mozfis.core.entity.BaseEntity;
import org.fao.mozfis.core.filter.Views;
import org.fao.mozfis.forest.model.ProductEntity;
import org.fao.mozfis.operator.model.OperatorEntity;
import org.fao.mozfis.request.model.RequestEntity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * The domain entity for a License
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "license", uniqueConstraints = { @UniqueConstraint(columnNames = "license_number") })
public class LicenseEntity extends BaseEntity {

	@NotBlank
	@Column(name = "license_number")
	private String licenseNumber;

	@Positive
	private int year = -1;

	private String description;

	@JsonView(Views.Detail.class)
	@JoinColumn(name = "request_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private RequestEntity request;

	@NotNull
	@Column(name = "request_id", nullable = false, insertable = false, updatable = false)
	private Long requestId = -1L;

	@JsonView(Views.Detail.class)
	@JoinColumn(name = "operator_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private OperatorEntity operator;

	@NotNull
	@Column(name = "operator_id", nullable = false, insertable = false, updatable = false)
	private Long operatorId = -1L;
	
	//TODO: add stage

	@JsonView(Views.Detail.class)
	@JsonManagedReference
	@Transient
	private List<ProductEntity> products;

	public LicenseEntity() {
	}

	public LicenseEntity(Long id) {
		setId(id);
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
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
		setRequestId(request != null ? request.getId() : null);
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
		setOperatorId(operator != null ? operator.getId() : null);
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
		result = prime * result + ((licenseNumber == null) ? 0 : licenseNumber.hashCode());
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
		if (licenseNumber == null) {
			if (other.licenseNumber != null)
				return false;
		} else if (!licenseNumber.equals(other.licenseNumber))
			return false;
		return true;
	}

}