package org.fao.mozfis.request.model;

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
 * The domain entity for the Type of the Product that will be exploited
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "product_type")
public class ProductTypeEntity extends BaseEntity {

	@NotBlank
	private String name;

	@JsonView(Views.Detail.class)
	@JoinColumn(name = "product_category_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductCategoryEntity productCategory;

	@NotNull
	@Column(name = "product_category_id", nullable = false, insertable = false, updatable = false)
	private Long productCategoryId = -1L;

	public ProductTypeEntity() {
	}

	public ProductTypeEntity(Long id) {
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCategoryEntity getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategoryEntity productCategory) {
		this.productCategory = productCategory;
	}

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
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
		ProductTypeEntity other = (ProductTypeEntity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}