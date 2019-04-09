package org.net5ijy.oauth2.controller;

import org.net5ijy.oauth2.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class TestController {

	private static Logger log = LoggerFactory.getLogger(TestController.class);

	@RequestMapping(value = "/demo")
	@ResponseBody
	public ResponseMessage getDemo() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		log.info(auth.toString());
		log.info(((OAuth2Authentication) auth).getOAuth2Request().getScope()
				.toString());
		return ResponseMessage.success();
	}
}
