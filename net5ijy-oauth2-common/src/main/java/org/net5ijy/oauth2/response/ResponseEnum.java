package org.net5ijy.oauth2.response;

/**
 * 响应码枚举
 *
 * @author xuguofeng
 * @date 2019/8/30 14:07
 */
public enum ResponseEnum {

  /**
   * 成功
   */
  SUCCESS("0", "OK"),

  /**
   * 异常
   */
  ERROR("900001", "ERROR");

  ResponseEnum(String code, String message) {
    this.code = code;
    this.message = message;
  }

  private String code;

  private String message;

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
