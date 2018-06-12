package org.fao.mozfis.license.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Meta Model for {@link LicenseEntity}
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@StaticMetamodel(LicenseEntity.class)
public abstract class LicenseEntity_ {

	private LicenseEntity_() {
	}

	public static volatile SingularAttribute<LicenseEntity, String> year;
	public static volatile SingularAttribute<LicenseEntity, String> licenseNumber;
	public static volatile SingularAttribute<LicenseEntity, String> operatorNuit;
	public static volatile SingularAttribute<LicenseEntity, Long> request;

}