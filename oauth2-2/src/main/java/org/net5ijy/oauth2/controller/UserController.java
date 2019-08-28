package org.net5ijy.oauth2.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.net5ijy.oauth2.bean.User;
import org.net5ijy.oauth2.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息接口
 *
 * @author xuguofeng
 * @date 2019/8/28 12:03
 */
@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Resource
  private UserService userService;

  @RequestMapping(value = "/list")
  @ResponseBody
  public List<User> list() {
    List<User> users = userService.getUsers();
    log.info(users.toString());
    log.info(users.toString());
    log.info(users.toString());
    log.info(users.toString());
    return users;
  }

  public static void main(String[] args) {

    String cmd = "D:\\app\\curl-7.64.1-win64\\bin\\curl.exe -I http://localhost:7001/users/list?access_token=628b96da-707d-4116-88fc-5ea8ed2762a1";

    for (int i = 0; i < Integer.MAX_VALUE; i++) {

      Runtime r = Runtime.getRuntime();

      try {

        Process process = r.exec(cmd);

        InputStream in = process.getInputStream();

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(in, "UTF-8"));

        String line = reader.readLine();

        while (line != null) {

          System.out.println(line);

          line = reader.readLine();
        }

      } catch (IOException e1) {
        e1.printStackTrace();
      }

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  // #!/bin/bash
  //
  // while((1<2))
  // do
  // curl -I http://...
  // sleep 2
  // done
}
