package org.fao.mozfis.territory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;
import org.fao.mozfis.core.filter.Views;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * The domain entity for a Locality
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "locality")
public class LocalityEntity extends BaseEntity {

	@NotBlank
	private String name;

	@JsonView(Views.Detail.class)
	@JoinColumn(name = "administrative_post_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private AdministrativePostEntity administrativePost;

	@NotNull
	@Column(name = "administrative_post_id", nullable = false, insertable = false, updatable = false)
	private Long administrativePostId = -1L;

	public LocalityEntity() {
	}

	public LocalityEntity(Long id) {
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AdministrativePostEntity getAdministrativePost() {
		return administrativePost;
	}

	public void setAdministrativePost(AdministrativePostEntity administrativePost) {
		this.administrativePost = administrativePost;
	}

	public Long getAdministrativePostId() {
		return administrativePostId;
	}

	public void setAdministrativePostId(Long administrativePostId) {
		this.administrativePostId = administrativePostId;
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