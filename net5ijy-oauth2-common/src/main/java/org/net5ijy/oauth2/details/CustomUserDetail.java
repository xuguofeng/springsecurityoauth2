package org.net5ijy.oauth2.details;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * org.net5ijy.oauth2.details.CustomUserDetail
 *
 * @author XGF
 * @date 2019/9/19 21:25
 */
public class CustomUserDetail extends User {

  private Collection<String> urls;

  public CustomUserDetail(String username, String password,
      Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
  }

  public CustomUserDetail(String username, String password, boolean enabled,
      boolean accountNonExpired,
      boolean credentialsNonExpired, boolean accountNonLocked,
      Collection<? extends GrantedAuthority> authorities) {
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
        authorities);
  }

  public Collection<String> getUrls() {
    return urls;
  }

  public void setUrls(Collection<String> urls) {
    this.urls = urls;
  }
}
