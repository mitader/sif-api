package org.fao.mozfis.core.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

/**
 * Application Event to be called after persist 
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public class CreateResourceEvent extends ApplicationEvent {

	private static final long serialVersionUID = 5570756458451891991L;

	private HttpServletResponse response;
	private Long code;

	public CreateResourceEvent(Object source, HttpServletResponse response, Long entityId) {
		super(source);
		this.response = response;
		this.code = entityId;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCode() {
		return code;
	}

}