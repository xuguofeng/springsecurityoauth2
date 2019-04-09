package org.net5ijy.oauth2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class TestController {

	Logger log = LoggerFactory.getLogger(TestController.class);

	@RequestMapping(value = "order/demo")
	public String getDemo() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		log.info(auth.toString());
		return "Hello world";
	}
}
