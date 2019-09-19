package org.net5ijy.oauth2.configuration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.net5ijy.oauth2.details.CustomUserDetail;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

/**
 * Implementation of UserAuthenticationConverter. Converts to and from an Authentication using name,
 * authorities and resource urls.
 *
 * @author XGF
 * @date 2019/9/19 20:50
 */
@Slf4j
public class CustomUserAuthenticationConverter extends DefaultUserAuthenticationConverter {

  @Override
  public Map<String, ?> convertUserAuthentication(Authentication authentication) {

    CustomUserDetail principal = (CustomUserDetail) authentication.getPrincipal();

    Map<String, Object> response = new HashMap<>(16);

    response.putAll(super.convertUserAuthentication(authentication));

    response.put("urls", principal.getUrls());

    log.info("CustomUserAuthenticationConverter.convertUserAuthentication, response: {}", response);

    return response;
  }

  @Override
  public Authentication extractAuthentication(Map<String, ?> map) {

    Authentication authentication = super.extractAuthentication(map);

    CustomUserDetail userDetail =
        new CustomUserDetail(
            authentication.getPrincipal().toString(),
            "",
            authentication.getAuthorities());

    Object urls = map.get("urls");

    if (urls instanceof Set) {
      userDetail.setUrls(getUserUrls((Set) urls));
    }

    Authentication auth =
        new UsernamePasswordAuthenticationToken(userDetail, "N/A", authentication.getAuthorities());

    log.info("CustomUserAuthenticationConverter.extractAuthentication, authentication: {}", auth);

    return auth;
  }

  private Set<String> getUserUrls(Set urls) {
    Set<String> u = new HashSet<>();
    for (Object url : urls) {
      u.add(url.toString());
    }
    return u;
  }
}
