package org.fao.mozfis.core.service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base class for all read only transactional services
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Service
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, rollbackFor = { NoResultException.class,
		ConstraintViolationException.class })
public @interface TransactionalReadOnly {
	String value() default "";
}
