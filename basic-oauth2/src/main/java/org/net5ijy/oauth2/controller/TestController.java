package org.net5ijy.oauth2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 资源
 *
 * @author xuguofeng
 * @date 2019/8/28 14:30
 */
@Slf4j
@RestController
@RequestMapping(value = "/")
public class TestController {

  @RequestMapping(value = "order/demo")
  public String getDemo() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    log.info(auth.toString());
    return "Hello world";
  }
}
