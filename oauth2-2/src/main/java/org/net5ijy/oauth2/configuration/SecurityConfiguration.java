package org.net5ijy.oauth2.configuration;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security配置
 *
 * @author xuguofeng
 * @date 2019/8/28 11:57
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Resource
  private UserDetailsService userDetailsService;

  @Resource
  private PasswordEncoder passwordEncoder;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  private AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService);
    authenticationProvider.setPasswordEncoder(passwordEncoder);
    authenticationProvider.setHideUserNotFoundExceptions(false);
    return authenticationProvider;
  }

  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers(
        "/css/**", "/js/**", "/fonts/**", "/icon/**", "/favicon.ico");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.requestMatchers()
        .antMatchers(
            "/login", "/login-error", "/oauth/authorize", "/oauth/token")
        .and()
        .authorizeRequests()
        .antMatchers("/login", "/login-error").permitAll()
        .anyRequest().authenticated();

    // 登录页面
    http.formLogin().loginPage("/login").failureUrl("/login-error");

    // 禁用CSRF
    http.csrf().disable();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth)
      throws Exception {
    auth.userDetailsService(userDetailsService);
    auth.authenticationProvider(authenticationProvider());
  }

  public static void main(String[] args) {
    System.out.println(new BCryptPasswordEncoder().encode("123456"));
  }
}
