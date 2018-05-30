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
 * The domain entity for a Locality
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "locality")
public class LocalityEntity extends BaseEntity {

	@NotNull
	private String name;

	@JoinColumn(name = "administrative_post_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private AdministrativePostEntity administrativePost;

	@NotNull
	@Column(name = "administrative_post_id", nullable = false, insertable = false, updatable = false)
	private Long administrativePostId;

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