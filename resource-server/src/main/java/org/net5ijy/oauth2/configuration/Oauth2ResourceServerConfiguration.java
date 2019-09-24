package org.net5ijy.oauth2.configuration;

import java.io.IOException;
import javax.annotation.Resource;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.StandardHttpRequestRetryHandler;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * Oauth2资源服务器配置
 *
 * @author xuguofeng
 * @date 2019/8/28 11:23
 */
@Configuration
public class Oauth2ResourceServerConfiguration extends
    ResourceServerConfigurerAdapter {

  private static final String CHECK_TOKEN_URL = "http://localhost:7002/oauth/check_token";

  @Resource
  private RestTemplate restTemplate;

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {

    RemoteTokenServices tokenService = new RemoteTokenServices();

    tokenService.setRestTemplate(restTemplate);

    tokenService.setCheckTokenEndpointUrl(CHECK_TOKEN_URL);
    tokenService.setClientId("net5ijy");
    tokenService.setClientSecret("12345678");

    DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
    defaultAccessTokenConverter.setUserTokenConverter(new CustomUserAuthenticationConverter());
    tokenService.setAccessTokenConverter(defaultAccessTokenConverter);

    resources.tokenServices(tokenService);
  }

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate(httpRequestFactory());
    restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
      @Override
      // Ignore 400
      public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getRawStatusCode() != HttpStatus.BAD_REQUEST.value()) {
          super.handleError(response);
        }
      }
    });
    return restTemplate;
  }

  private ClientHttpRequestFactory httpRequestFactory() {
    return new HttpComponentsClientHttpRequestFactory(httpClient());
  }

  @SuppressWarnings("unused")
  private HttpClient httpClient() {

    Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
        .register("http", PlainConnectionSocketFactory.getSocketFactory())
        .register("https", SSLConnectionSocketFactory.getSocketFactory())
        .build();

    PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
    // 设置整个连接池最大连接数，根据场景决定
    manager.setMaxTotal(200);
    // 路由是对maxTotal的细分
    manager.setDefaultMaxPerRoute(100);

    RequestConfig requestConfig = RequestConfig.custom()
        // 服务器返回数据(response)的时间，超出该时间抛出read timeout
        .setSocketTimeout(10000)
        // 连接服务器(握手成功)的时间，超出该时间抛出connect timeout
        .setConnectTimeout(5000)
        // 从连接池中获取连接的超时时间，超时间未获取到可用连接
        // 会抛出ConnectionPoolTimeoutException: Timeout waiting for connection from pool
        .setConnectionRequestTimeout(1000)
        .build();

    return HttpClients.custom().setConnectionManager(manager)
        .setRetryHandler(new StandardHttpRequestRetryHandler())
        .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
        .setDefaultRequestConfig(requestConfig)
        .build();
  }
}
