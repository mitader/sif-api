package org.fao.mozfis.request.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;
import org.fao.mozfis.core.filter.Views;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * The domain entity for a specific Stage of the Forest Exploration Request
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "request_stage")
public class RequestStageEntity extends BaseEntity {

	@NotNull
	private String description = "auto";

	@Column(name = "effective_date")
	private LocalDate effectiveDate;

	@NotNull
	@JsonView(Views.Detail.class)
	@JoinColumn(name = "stage_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private StageEntity stage;

	@Column(name = "stage_id", nullable = false, insertable = false, updatable = false)
	private Long stageId;

	@NotNull
	@JsonBackReference
	@JoinColumn(name = "request_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private RequestEntity request = null;

	@Column(name = "request_id", nullable = false, insertable = false, updatable = false)
	private Long requestId;

	@JoinColumn(name = "document_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private DocumentEntity document;

	@Column(name = "document_id", nullable = true, insertable = false, updatable = false)
	private Long documentId;

	public RequestStageEntity() {
	}

	public RequestStageEntity(StageEntity stage) {
		this.stage = stage;
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

	public DocumentEntity getDocument() {
		return document;
	}

	public void setDocument(DocumentEntity document) {
		this.document = document;
		setDocumentId(document != null ? document.getId() : null);
	}

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((stageId == null) ? 0 : stageId.hashCode());
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