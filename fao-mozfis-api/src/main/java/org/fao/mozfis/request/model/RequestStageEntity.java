package org.fao.mozfis.request.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;

/**
 * The domain entity for a specific Stage of the Forest Exploration Request
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "request_stage", uniqueConstraints = { @UniqueConstraint(columnNames = "number") })
public class RequestStageEntity extends BaseEntity {

	@NotNull
	private String description;

	@Column(name = "effective_date")
	private LocalDate effectiveDate;

	@JoinColumn(name = "stage_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private StageEntity stage;
	
	@NotNull
	@Column(name = "stage_id", nullable = false, insertable = false, updatable = false)
	private Long stageId;

	@JoinColumn(name = "request_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private RequestEntity request;
	
	@NotNull
	@Column(name = "request_id", nullable = false, insertable = false, updatable = false)
	private Long requestId;

	// TODO: add attachment field
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((stageId == null) ? 0 : stageId.hashCode());
		return result;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public StageEntity getStage() {
		return stage;
	}

	public void setStage(StageEntity stage) {
		this.stage = stage;
	}

	public Long getStageId() {
		return stageId;
	}

	public void setStageId(Long stageId) {
		this.stageId = stageId;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestStageEntity other = (RequestStageEntity) obj;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (stageId == null) {
			if (other.stageId != null)
				return false;
		} else if (!stageId.equals(other.stageId))
			return false;
		return true;
	}

}