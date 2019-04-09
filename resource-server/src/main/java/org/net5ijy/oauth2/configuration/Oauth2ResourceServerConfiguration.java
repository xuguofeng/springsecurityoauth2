package org.net5ijy.oauth2.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
public class Oauth2ResourceServerConfiguration extends
		ResourceServerConfigurerAdapter {

	private static final String URL = "http://localhost:7002/oauth/check_token";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources)
			throws Exception {

		RemoteTokenServices tokenService = new RemoteTokenServices();
		tokenService.setCheckTokenEndpointUrl(URL);
		tokenService.setClientId("net5ijy");
		tokenService.setClientSecret("12345678");

		resources.tokenServices(tokenService);
	}
}
