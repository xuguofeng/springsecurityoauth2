package org.net5ijy.oauth2.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录接口
 *
 * @author xuguofeng
 * @date 2019/8/28 12:02
 */
@RestController
public class LoginController {

  @GetMapping("/login")
  public ModelAndView login() {
    return new ModelAndView("login");
  }

  @GetMapping("/login-error")
  public ModelAndView loginError(Model model) {
    model.addAttribute("loginError", true);
    model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
    return new ModelAndView("login", "userModel", model);
  }
}
