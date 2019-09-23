package org.net5ijy.oauth2.service.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import org.net5ijy.oauth2.details.CustomUserDetail;
import org.net5ijy.oauth2.entity.Role;
import org.net5ijy.oauth2.entity.User;
import org.net5ijy.oauth2.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsService实现
 *
 * @author xuguofeng
 * @date 2019/8/28 12:07
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Resource
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {

    User user = userService.getUser(username);
    if (user == null || user.getId() < 1) {
      throw new UsernameNotFoundException("Username not found: "
          + username);
    }

    CustomUserDetail userDetail =
        new CustomUserDetail(
            user.getUsername(),
            user.getPassword(),
            true,
            true,
            true,
            true,
            getGrantedAuthorities(user)
        );

    Set<String> urls = new HashSet<>();
    urls.add("/user/{id}");
    urls.add("/user/users");

    userDetail.setUrls(urls);

    return userDetail;
  }

  private Collection<? extends GrantedAuthority> getGrantedAuthorities(
      User user) {
    Set<GrantedAuthority> authorities = new HashSet<>();
    for (Role role : user.getRoles()) {
      authorities
          .add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
    }
    return authorities;
  }
}
