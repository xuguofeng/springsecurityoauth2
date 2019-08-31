package org.net5ijy.oauth2.service.impl;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.net5ijy.oauth2.entity.User;
import org.net5ijy.oauth2.repository.UserRepository;
import org.net5ijy.oauth2.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 用户业务层实现
 *
 * @author xuguofeng
 * @date 2019/8/28 12:06
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

  @Resource
  private UserRepository userRepository;

  @Resource
  private JdbcTemplate jdbcTemplate;

  @Override
  public User getUser(String username) {
    System.out.println("jdbcTemplate = " + jdbcTemplate);
    return userRepository.findByUsername(username);
  }
}
