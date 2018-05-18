package org.fao.mozfis.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration Property Class
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@ConfigurationProperties("mitader-fis")
public class MozFisProperty {

	private Security security = new Security();

	public Security getSecurity() {
		return security;
	}

	public static class Security {
		private String allowedOrigin;

		public String getAllowedOrigin() {
			return allowedOrigin;
		}

		public void setAllowedOrigin(String allowedOrigin) {
			this.allowedOrigin = allowedOrigin;
		}

	}

}