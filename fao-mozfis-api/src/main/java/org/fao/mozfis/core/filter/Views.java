package org.fao.mozfis.core.filter;

/**
 * Base class for all JSON views
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
public final class Views {

	public static class Summary {
		// just to decorate Summary json view rest resources
	}

	public static class Detail extends Summary {
		// just to decorate Detailed json view rest resources
	}

	private Views() {
	}
}
