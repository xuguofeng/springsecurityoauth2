package org.net5ijy.oauth2.controller;

import java.util.Map;

import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 确认授权
 *
 * @author xuguofeng
 * @date 2019/8/28 12:01
 */
@Controller
@SessionAttributes("authorizationRequest")
public class GrantController {

  @RequestMapping("/oauth/confirm_access")
  public ModelAndView getAccessConfirmation(Map<String, Object> model) {

    AuthorizationRequest authorizationRequest = (AuthorizationRequest) model
        .get("authorizationRequest");

    ModelAndView view = new ModelAndView("base-grant");
    view.addObject("clientId", authorizationRequest.getClientId());
    view.addObject("scope", authorizationRequest.getScope().toArray()[0]);

    return view;
  }
}
