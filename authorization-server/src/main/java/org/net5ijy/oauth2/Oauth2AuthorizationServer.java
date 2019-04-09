package org.net5ijy.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@MapperScan("org.net5ijy.oauth2.repository")
public class Oauth2AuthorizationServer {

	public static void main(String[] args) {

		// args = new String[] { "--debug" };

		SpringApplication.run(Oauth2AuthorizationServer.class, args);
	}
}
