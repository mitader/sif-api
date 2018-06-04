package org.fao.mozfis.operator.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Meta Model for {@link OperatorEntity}
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@StaticMetamodel(OperatorEntity.class)
public abstract class OperatorEntity_ {

	private OperatorEntity_() {
	}

	public static volatile SingularAttribute<OperatorEntity, String> nuit;
	public static volatile SingularAttribute<OperatorEntity, String> name;
}