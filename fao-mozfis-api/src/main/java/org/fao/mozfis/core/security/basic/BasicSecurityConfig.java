package org.fao.mozfis.core.security.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security Configuration only for Development environment
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Profile("development")
@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("admin")
			.password("password")
			.roles("SUPER_ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			//.antMatchers("/provinces").permitAll()
			.anyRequest().authenticated()
			.and().httpBasic()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().csrf()
			.disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}