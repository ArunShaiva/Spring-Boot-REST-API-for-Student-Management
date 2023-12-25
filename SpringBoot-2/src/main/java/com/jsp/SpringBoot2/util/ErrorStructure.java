package com.jsp.SpringBoot2.util;

import org.springframework.stereotype.Component;

@Component
public class ErrorStructure<G> {

	private int status;
	private String message;
	private G rootCause;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public G getRootCause() {
		return rootCause;
	}

	public void setRootCause(G rootCause) {
		this.rootCause = rootCause;
	}

}
