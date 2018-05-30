package org.fao.mozfis.request.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;

/**
 * The domain entity for the Type of the Product that will be exploited
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "product_subtype")
public class ProductSubTypeEntity extends BaseEntity {

	@NotNull
	private String name;

	@JoinColumn(name = "product_type_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductTypeEntity productType;

	@NotNull
	@Column(name = "product_type_id", nullable = false, insertable = false, updatable = false)
	private Long productTypeId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductTypeEntity getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeEntity productType) {
		this.productType = productType;
	}

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
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
		ProductSubTypeEntity other = (ProductSubTypeEntity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}