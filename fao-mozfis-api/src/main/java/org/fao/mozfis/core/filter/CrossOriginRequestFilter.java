package org.fao.mozfis.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fao.mozfis.core.config.MozFisProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * CORS Filter for every request
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CrossOriginRequestFilter implements Filter {

	private static final String PREFLIGHT_REQUEST_METHOD = "OPTIONS";

	@Autowired
	private MozFisProperty propertyResource;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// nothing to do.
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		response.setHeader("Access-Control-Allow-Origin", propertyResource.getSecurity().getAllowedOrigin());
		response.setHeader("Access-Control-Allow-Credentials", "true");

		if (isPreFlightRequestFromAllowedOrigin(request)) {
			// Consider HTTP Status 200 OK for all pre flight requests
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
			response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
			response.setHeader("Access-Control-Allow-Max-Age", "3600");
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			// Now let spring security take care of the request
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// nothing to do.
	}

	private boolean isPreFlightRequestFromAllowedOrigin(HttpServletRequest request) {

		boolean trustedOrigin = propertyResource.getSecurity().getAllowedOrigin().equals(request.getHeader("Origin"));
		boolean preflightRequest = PREFLIGHT_REQUEST_METHOD.equals(request.getMethod());

		return trustedOrigin && preflightRequest;
	}

}
