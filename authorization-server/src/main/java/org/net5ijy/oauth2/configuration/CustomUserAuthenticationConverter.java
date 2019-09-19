package org.net5ijy.oauth2.configuration;

import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.stereotype.Component;

@Component
public class CustomUserAuthenticationConverter extends DefaultUserAuthenticationConverter {

  @Override
  public Map<String, ?> convertUserAuthentication(Authentication authentication) {

    System.out.println(">>> 自定义的UserAuthenticationConverter");

    Map<String, ?> response = super.convertUserAuthentication(authentication);

    return response;
  }
}
