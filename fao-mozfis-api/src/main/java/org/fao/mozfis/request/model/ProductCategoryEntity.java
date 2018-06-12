package org.fao.mozfis.request.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.fao.mozfis.core.entity.BaseEntity;

/**
 * The domain entity to Aggregate the Type of the Product that will be exploited
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "product_category")
public class ProductCategoryEntity extends BaseEntity {

	@NotBlank
	private String name;

	public ProductCategoryEntity() {
	}

	public ProductCategoryEntity(Long id) {
		setId(id);
		this.name = "auto";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		ProductCategoryEntity other = (ProductCategoryEntity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}