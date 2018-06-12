package org.fao.mozfis.core.service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base class for all services
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Documented
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { NoResultException.class,
		ConstraintViolationException.class })
public @interface TransactionalModify {
	String value() default "";
}
