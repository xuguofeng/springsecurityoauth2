package org.net5ijy.oauth2.service;

import org.net5ijy.oauth2.entity.User;

/**
 * 用户业务层
 *
 * @author xuguofeng
 * @date 2019/8/28 12:05
 */
public interface UserService {

  /**
   * 根据用户名获取用户信息
   *
   * @param username 用户名
   * @return 用户对象
   * @author xuguofeng
   * @date 2019/8/28 12:06
   */
  User getUser(String username);
}
