package org.net5ijy.oauth2.service.impl;

import org.net5ijy.oauth2.bean.User;
import org.net5ijy.oauth2.repository.UserRepository;
import org.net5ijy.oauth2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}
}
