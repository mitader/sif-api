
package org.fao.mozfis.request.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;

/**
 * The domain entity for a Contract
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "document")
public class DocumentEntity extends BaseEntity {

	@NotBlank
	@Column(name = "file_name", length = 200, nullable = false)
	private String fileName;

	@NotBlank
	@Column(name = "file_name_uuid", length = 200, nullable = false)
	private String fileNameUuid;

	@NotBlank
	@Column(name = "content_type", length = 200, nullable = false)
	private String contentType;

	@NotNull
	@Lob
	@Basic(fetch = FetchType.LAZY)
	/**
	 * lenght in bytes
	 * 
	 * <pre>
	 *      	   0 < length <=      255  -->  `TINYBLOB`
	 *			 255 < length <=    65535  -->  `BLOB`
	 *		   65535 < length <= 16777215  -->  `MEDIUMBLOB`
	 *		16777215 < length <=    2³¹-1  -->  `LONGBLOB`
	 * </pre>
	 */
	@Column(nullable = false, columnDefinition = "LONGBLOB NOT NULL")
	private byte[] contents;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileNameUuid() {
		return fileNameUuid;
	}

	public void setFileNameUuid(String fileNameUuid) {
		this.fileNameUuid = fileNameUuid;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getContents() {
		return contents;
	}

	public void setContents(byte[] contents) {
		this.contents = contents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + ((fileNameUuid == null) ? 0 : fileNameUuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}