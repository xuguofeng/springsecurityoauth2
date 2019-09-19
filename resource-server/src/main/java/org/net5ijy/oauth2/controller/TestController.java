package org.net5ijy.oauth2.controller;

import lombok.extern.slf4j.Slf4j;
import org.net5ijy.oauth2.response.Response;
import org.net5ijy.oauth2.response.ResponseEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 资源
 *
 * @author xuguofeng
 * @date 2019/8/28 12:02
 */
@Slf4j
@RestController
@RequestMapping(value = "/order")
public class TestController {

  @RequestMapping(value = "/demo")
  @ResponseBody
  public Response getDemo() {
    Authentication auth = SecurityContextHolder.getContext()
        .getAuthentication();

    log.info(auth.getClass().getName());
    log.info(auth.getDetails().getClass().getName());
    log.info(auth.getCredentials().getClass().getName());
    log.info(auth.getPrincipal().getClass().getName());
    log.info(((OAuth2Authentication) auth).getOAuth2Request().getScope().toString());
    return new Response(ResponseEnum.SUCCESS);
  }
}
