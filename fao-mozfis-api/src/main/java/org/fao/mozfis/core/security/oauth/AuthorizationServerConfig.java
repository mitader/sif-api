package org.fao.mozfis.core.security.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * OAuth Authorization Server Configuration
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Profile("production")
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//TODO: read from jdbc datasource
		clients
			.inMemory()
			.withClient("mitader-fis-web")
			.secret("m!t@d3rF!S")
			.scopes("read", "write")
			.authorizedGrantTypes("password")
			.accessTokenValiditySeconds(1800);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore());
	}

	@Bean
	public TokenStore tokenStore() {
		//TODO: store as a cookie or secured file system 
		return new InMemoryTokenStore();
	}

}