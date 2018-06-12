package org.fao.mozfis.request.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Meta Model for {@link RequestEntity}
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@StaticMetamodel(RequestEntity.class)
public abstract class RequestEntity_ {

	private RequestEntity_() {
	}

	public static volatile SingularAttribute<RequestEntity, String> year;
	public static volatile SingularAttribute<RequestEntity, String> regime;
	public static volatile SingularAttribute<RequestEntity, String> operatorNuit;
	public static volatile SingularAttribute<RequestEntity, Long> province;
	public static volatile SingularAttribute<RequestEntity, String> stage;

}