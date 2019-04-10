package org.net5ijy.oauth2.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.net5ijy.oauth2.bean.User;
import org.net5ijy.oauth2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list")
	@ResponseBody
	public List<User> list() {
		List<User> users = userService.getUsers();
		log.info(users.toString());
		return users;
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		String md5 = DigestUtils.md5Hex(new FileInputStream(
				"D:\\____\\springsecurityoauth\\bsdiff\\测试日志\\log2.zip"));
		System.out.println(md5);
	}
}
