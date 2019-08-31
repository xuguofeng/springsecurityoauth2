package org.net5ijy.oauth2.configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.net5ijy.oauth2.provider.code.RedisAuthorizationCodeServices;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * Oauth2授权服务器配置
 *
 * @author xuguofeng
 * @date 2019/8/28 11:23
 */
@Configuration
public class Oauth2AuthorizationServerConfiguration extends
    AuthorizationServerConfigurerAdapter {

  @Resource
  private UserDetailsService userDetailsService;

  @Resource
  private AuthenticationManager authenticationManager;

  @Resource
  private DataSource dataSource;

  @Resource
  private RedisConnectionFactory redisConnectionFactory;

  @Override
  public void configure(ClientDetailsServiceConfigurer clients)
      throws Exception {

    // 数据库管理client
    clients.withClientDetails(new JdbcClientDetailsService(dataSource));
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

    // 用户信息查询服务
    endpoints.userDetailsService(userDetailsService);

    // 数据库管理access_token和refresh_token
    TokenStore tokenStore = new JdbcTokenStore(dataSource);

    // 使用Redis管理access_token和refresh_token
    TokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);

    endpoints.tokenStore(redisTokenStore);

    ClientDetailsService clientService = new JdbcClientDetailsService(
        dataSource);

    DefaultTokenServices tokenServices = new DefaultTokenServices();
    tokenServices.setTokenStore(redisTokenStore);
    tokenServices.setSupportRefreshToken(true);
    tokenServices.setClientDetailsService(clientService);

    // tokenServices.setAccessTokenValiditySeconds(180);
    // tokenServices.setRefreshTokenValiditySeconds(180);

    endpoints.tokenServices(tokenServices);

    endpoints.authenticationManager(authenticationManager);

    // 数据库管理授权码
//    endpoints.authorizationCodeServices(new JdbcAuthorizationCodeServices(dataSource));
    endpoints.authorizationCodeServices(new RedisAuthorizationCodeServices(redisConnectionFactory));

    // 数据库管理授权信息
//    ApprovalStore approvalStore = new JdbcApprovalStore(dataSource);
    TokenApprovalStore approvalStore = new TokenApprovalStore();
    approvalStore.setTokenStore(redisTokenStore);
    endpoints.approvalStore(approvalStore);
  }
}
