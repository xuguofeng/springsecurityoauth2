package org.net5ijy.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class Oauth2ResourceServer {

	public static void main(String[] args) {

		// args = new String[] { "--debug" };

		SpringApplication.run(Oauth2ResourceServer.class, args);
	}
}
