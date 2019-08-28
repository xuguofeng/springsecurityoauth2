package org.net5ijy.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * org.net5ijy.oauth2.BasicOauth2Application 类
 *
 * @author xuguofeng
 * @date 2019/8/28 14:30
 */
@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class BasicOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(BasicOauth2Application.class, args);
	}
}
