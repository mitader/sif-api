package org.fao.mozfis.core.event;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Listener for {@link CreateResourceEvent}
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Component
public class CreateResourceListener implements ApplicationListener<CreateResourceEvent> {

	@Override
	public void onApplicationEvent(CreateResourceEvent event) {

		HttpServletResponse response = event.getResponse();
		Long entityId = event.getCode();

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{objid}").buildAndExpand(entityId).toUri();

		response.setHeader("Location", uri.toString());
	}

}