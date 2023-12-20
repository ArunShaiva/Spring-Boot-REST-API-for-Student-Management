package com.jsp.login.exception;

public class UnmatchedPasswordException extends RuntimeException {

	private String msg;

	public UnmatchedPasswordException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
