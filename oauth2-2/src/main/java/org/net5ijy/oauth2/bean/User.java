package org.net5ijy.oauth2.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户
 *
 * @author xuguofeng
 * @date 2019/8/28 11:52
 */
@Data
@EqualsAndHashCode(exclude = {"id"})
public class User implements Serializable {

  private static final long serialVersionUID = 6641328611539019031L;

  private Integer id;

  private String username;

  private String password;

  private String phone;

  private String email;

  private Set<Role> roles = new HashSet<Role>();

  // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
