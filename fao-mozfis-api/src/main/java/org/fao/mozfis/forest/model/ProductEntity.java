package org.fao.mozfis.forest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;
import org.fao.mozfis.license.model.LicenseEntity;
import org.fao.mozfis.request.model.RequestEntity;

/**
 * The domain entity for a Product
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {

	@Column(name = "requested_quantity")
	private BigDecimal requestedQuantity;

	@NotNull
	@Column(name = "authorized_quantity")
	private BigDecimal authorizedQuantity;

	@JoinColumn(name = "request_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private RequestEntity request;

	@NotNull
	@Column(name = "request_id", nullable = false, insertable = false, updatable = false)
	private Long requestId;

	@JoinColumn(name = "license_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private LicenseEntity license;

	@NotNull
	@Column(name = "license_id", nullable = false, insertable = false, updatable = false)
	private Long licenseId;

	@JoinColumn(name = "specie_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private SpecieEntity specie;

	@NotNull
	@Column(name = "specie_id", nullable = false, insertable = false, updatable = false)
	private Long specieId;

	public BigDecimal getRequestedQuantity() {
		return requestedQuantity;
	}

	public void setRequestedQuantity(BigDecimal requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	public BigDecimal getAuthorizedQuantity() {
		return authorizedQuantity;
	}

	public void setAuthorizedQuantity(BigDecimal authorizedQuantity) {
		this.authorizedQuantity = authorizedQuantity;
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

	public LicenseEntity getLicense() {
		return license;
	}

	public void setLicense(LicenseEntity license) {
		this.license = license;
	}

	public Long getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(Long licenseId) {
		this.licenseId = licenseId;
	}

	public SpecieEntity getSpecie() {
		return specie;
	}

	public void setSpecie(SpecieEntity specie) {
		this.specie = specie;
	}

	public Long getSpecieId() {
		return specieId;
	}

	public void setSpecieId(Long specieId) {
		this.specieId = specieId;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}