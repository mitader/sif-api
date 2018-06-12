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
import org.fao.mozfis.core.filter.Views;
import org.fao.mozfis.license.model.LicenseEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

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

	@Column(name = "authorized_quantity")
	private BigDecimal authorizedQuantity;

	@NotNull
	@JsonBackReference
	@JoinColumn(name = "license_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private LicenseEntity license;

	@Column(name = "license_id", nullable = false, insertable = false, updatable = false)
	private Long licenseId;

	@NotNull
	@JsonView(Views.Detail.class)
	@JoinColumn(name = "specie_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private SpecieEntity specie;

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

	public LicenseEntity getLicense() {
		return license;
	}

	public void setLicense(LicenseEntity license) {
		this.license = license;
		setLicenseId(license != null ? license.getId() : null);
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
		setSpecieId(specie != null ? specie.getId() : null);
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