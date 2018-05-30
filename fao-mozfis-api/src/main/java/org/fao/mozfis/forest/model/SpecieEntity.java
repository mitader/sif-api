package org.fao.mozfis.forest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.fao.mozfis.core.entity.BaseEntity;
import org.fao.mozfis.forest.util.Classification;
import org.fao.mozfis.forest.util.MeasurementUnit;

/**
 * The domain entity for a Specie
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Entity
@Table(name = "specie")
public class SpecieEntity extends BaseEntity {

	@NotNull
	@Column(name = "scientific_name")
	private String scientificName;

	@Column(name = "commercial_name")
	private String commercialName;

	@Column(name = "local_name")
	private String localName;

	@NotNull
	@Column(name = "minimum_diameter")
	private BigDecimal minumumDiameter;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "measurement_unit")
	private MeasurementUnit measurementUnit;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Classification classification;

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getCommercialName() {
		return commercialName;
	}

	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public BigDecimal getMinumumDiameter() {
		return minumumDiameter;
	}

	public void setMinumumDiameter(BigDecimal minumumDiameter) {
		this.minumumDiameter = minumumDiameter;
	}

	public MeasurementUnit getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
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