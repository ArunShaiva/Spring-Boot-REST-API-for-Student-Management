package com.jsp.SpringBoot2.exceptions;

public class StudentFoundByIdException extends RuntimeException {

	private String message;

	public StudentFoundByIdException(String message) {

		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "StudentFoundByIdException [message=" + message + "]";
	}

}
