package org.fao.mozfis.territory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;
import org.fao.mozfis.core.filter.Views;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * The domain entity for an Admiistrative Post
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "administrative_post")
public class AdministrativePostEntity extends BaseEntity {

	@NotNull
	private String name;

	@JsonView(Views.Detail.class)
	@JoinColumn(name = "district_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private DistrictEntity district;

	@NotNull
	@Column(name = "district_id", nullable = false, insertable = false, updatable = false)
	private Long districtId;

	public AdministrativePostEntity() {
	}

	public AdministrativePostEntity(Long id) {
		setId(id);
		this.name = "";
		this.districtId = -1L;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DistrictEntity getDistrict() {
		return district;
	}

	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
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