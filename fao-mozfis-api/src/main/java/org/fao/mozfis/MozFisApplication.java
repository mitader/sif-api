package org.fao.mozfis;

import org.fao.mozfis.core.config.MozFisProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@SpringBootApplication
@EnableConfigurationProperties(MozFisProperty.class)
public class MozFisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MozFisApplication.class, args);
	}
}