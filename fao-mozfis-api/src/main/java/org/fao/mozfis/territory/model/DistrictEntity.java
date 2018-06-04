package org.fao.mozfis.territory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;

/**
 * The domain entity for a District
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "district")
public class DistrictEntity extends BaseEntity {

	@NotNull
	private String name;

	@JoinColumn(name = "province_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ProvinceEntity province;

	@NotNull
	@Column(name = "province_id", nullable = false, insertable = false, updatable = false)
	private Long provinceId;

	public DistrictEntity() {
	}

	public DistrictEntity(Long id) {
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProvinceEntity getProvince() {
		return province;
	}

	public void setProvince(ProvinceEntity province) {
		this.province = province;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
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