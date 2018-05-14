package org.fao.mozfis.core.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Application Exception Handler
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@ControllerAdvice
public class MozFisExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String message = messageSource.getMessage("validation.invalid.request.parameters", null,
				LocaleContextHolder.getLocale());

		return super.handleExceptionInternal(ex, message, headers, HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = new ArrayList<>(ex.getBindingResult().getFieldErrors().size());

		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(messageSource.getMessage(error, LocaleContextHolder.getLocale()));
		}

		return super.handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class })
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public void handleEmptyResultDataAccessException() {
	}

	@ExceptionHandler({ DataIntegrityViolationException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
			WebRequest request) {

		String message = messageSource.getMessage("validation.integrity.violation", null,
				LocaleContextHolder.getLocale());

		return super.handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

}