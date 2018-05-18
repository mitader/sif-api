package org.fao.mozfis.user.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Meta Model for {@link UserEntity}
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ {

	private UserEntity_() {
	}

	public static volatile SingularAttribute<UserEntity, String> username;
	public static volatile SingularAttribute<UserEntity, String> fullname;
}