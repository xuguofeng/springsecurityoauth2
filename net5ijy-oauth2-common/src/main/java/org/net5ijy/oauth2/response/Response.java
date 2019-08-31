package org.net5ijy.oauth2.response;

import lombok.Data;

/**
 * 接口响应
 *
 * @author xuguofeng
 * @date 2019/8/30 14:07
 */
@Data
public class Response {

  private String code;

  private String message;

  private long responseTime = System.currentTimeMillis();

  private Object responseBody;

  public Response(ResponseEnum responseEnum) {
    this.code = responseEnum.getCode();
    this.message = responseEnum.getMessage();
  }

  public Response setResponseBody(Object responseBody) {
    this.responseBody = responseBody;
    return this;
  }
}
