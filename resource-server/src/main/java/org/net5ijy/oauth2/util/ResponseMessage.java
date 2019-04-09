package org.net5ijy.oauth2.util;

public class ResponseMessage {

	private Integer code;
	private String message;

	public ResponseMessage() {
		super();
	}

	public ResponseMessage(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static ResponseMessage success() {
		return new ResponseMessage(0, "操作成功");
	}

	public static ResponseMessage fail() {
		return new ResponseMessage(99, "操作失败");
	}

	@Override
	public String toString() {
		return "ResponseMessage [code=" + code + ", message=" + message + "]";
	}
}
