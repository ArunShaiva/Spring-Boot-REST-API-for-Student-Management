package com.jsp.login.exception;

public class InvalidPasswordException extends RuntimeException {

	private String msg;

	public InvalidPasswordException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
