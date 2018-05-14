package org.fao.mozfis.territory.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.fao.mozfis.core.entity.BaseEntity;

/**
 * The domain entity for a Province
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "province")
public class ProvinceEntity extends BaseEntity {

	@NotNull
	@Size(min = 3, max = 20)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}