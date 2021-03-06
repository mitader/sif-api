package org.fao.mozfis.request.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;

/**
 * The domain entity for a generic Stage of the Forest Exploration Request
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "stage")
public class StageEntity extends BaseEntity {

	public static final Long APPROVED = 16L;

	@NotNull
	private String name = "auto";

	@Column(name = "final_stage")
	private boolean finalStage;

	public StageEntity() {
	}

	public StageEntity(Long id) {
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFinalStage() {
		return finalStage;
	}

	public void setFinalStage(boolean finalStage) {
		this.finalStage = finalStage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		StageEntity other = (StageEntity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}