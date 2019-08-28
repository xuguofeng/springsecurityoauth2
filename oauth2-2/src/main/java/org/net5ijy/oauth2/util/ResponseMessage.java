package org.net5ijy.oauth2.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装响应信息
 *
 * @author xuguofeng
 * @date 2019/8/28 12:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {

  private Integer code;
  private String message;

  public static ResponseMessage success() {
    return new ResponseMessage(0, "操作成功");
  }

  public static ResponseMessage fail() {
    return new ResponseMessage(99, "操作失败");
  }
}
