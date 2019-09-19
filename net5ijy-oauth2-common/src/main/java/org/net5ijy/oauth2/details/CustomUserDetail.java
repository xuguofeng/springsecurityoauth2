package org.net5ijy.oauth2.details;

import java.util.Collection;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * org.net5ijy.oauth2.details.CustomUserDetail
 *
 * @author XGF
 * @date 2019/9/19 21:25
 */
public class CustomUserDetail extends User {

  private Set<String> urls;

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

  public Set<String> getUrls() {
    return urls;
  }

  public void setUrls(Set<String> urls) {
    this.urls = urls;
  }
}
