package org.net5ijy.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * org.net5ijy.oauth2.Oauth2ResourceServer 类
 *
 * @author xuguofeng
 * @date 2019/8/30 14:45
 */
@SpringBootApplication
@EnableResourceServer
public class Oauth2ResourceServer {

  public static void main(String[] args) {

//     args = new String[] { "--debug" };

    SpringApplication.run(Oauth2ResourceServer.class, args);
  }
}
