package org.fao.mozfis.operator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;
import org.fao.mozfis.core.filter.Views;
import org.fao.mozfis.territory.model.LocalityEntity;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * The domain entity for an Operator
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "operators", uniqueConstraints = { @UniqueConstraint(columnNames = "nuit") })
public class OperatorEntity extends BaseEntity {

	@NotNull
	private String nuit;

	@NotNull
	private String name;

	private String identification;

	private String email;

	private String phone;

	private String comments;

	@JsonView(Views.Detail.class)
	@JoinColumn(name = "locality_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private LocalityEntity locality;

	@NotNull
	@Column(name = "locality_id", nullable = false, insertable = false, updatable = false)
	private Long localityId;

	public String getNuit() {
		return nuit;
	}

	public void setNuit(String nuit) {
		this.nuit = nuit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalityEntity getLocality() {
		return locality;
	}

	public void setLocality(LocalityEntity locality) {
		this.locality = locality;
		setLocalityId(locality != null ? locality.getId() : null);
	}

	public Long getLocalityId() {
		return localityId;
	}

	public void setLocalityId(Long localityId) {
		this.localityId = localityId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nuit == null) ? 0 : nuit.hashCode());
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
		OperatorEntity other = (OperatorEntity) obj;
		if (nuit == null) {
			if (other.nuit != null)
				return false;
		} else if (!nuit.equals(other.nuit))
			return false;
		return true;
	}

}