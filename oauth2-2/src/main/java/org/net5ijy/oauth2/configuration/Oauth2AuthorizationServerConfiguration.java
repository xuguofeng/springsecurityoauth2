package org.net5ijy.oauth2.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
public class Oauth2AuthorizationServerConfiguration extends
		AuthorizationServerConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private DataSource dataSource;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients)
			throws Exception {

		// 数据库管理client
		clients.withClientDetails(new JdbcClientDetailsService(dataSource));
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
			throws Exception {

		// 用户信息查询服务
		endpoints.userDetailsService(userDetailsService);

		// 数据库管理access_token和refresh_token
		TokenStore tokenStore = new JdbcTokenStore(dataSource);

		endpoints.tokenStore(tokenStore);

		ClientDetailsService clientService = new JdbcClientDetailsService(
				dataSource);

		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setTokenStore(tokenStore);
		tokenServices.setSupportRefreshToken(true);
		tokenServices.setClientDetailsService(clientService);
		// tokenServices.setAccessTokenValiditySeconds(180);
		// tokenServices.setRefreshTokenValiditySeconds(180);

		endpoints.tokenServices(tokenServices);

		endpoints.authenticationManager(authenticationManager);

		// 数据库管理授权码
		endpoints.authorizationCodeServices(new JdbcAuthorizationCodeServices(
				dataSource));
		// 数据库管理授权信息
		ApprovalStore approvalStore = new JdbcApprovalStore(dataSource);
		endpoints.approvalStore(approvalStore);
	}
}
