package com.jsp.SpringBoot2.util;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class ResponseStructure<G> {

	private int status;
	private String message;
	private G data;

//	private List<G> lData;

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

	public G getData() {
		return data;
	}

	public void setData(G data) {
		this.data = data;
	}

//	public List<G> getlData() {
//		return lData;
//	}
//
//	public void setlData(List<G> lData) {
//		this.lData = lData;
//	}

}
