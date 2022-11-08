package com.cmt.sample.Exceptions;

import java.util.Date;

public class Errordetails {
	private String message;
	private int statuscode;
	
	public Errordetails(String message,int statuscode) {
		super();
		this.message=message;
		this.statuscode=statuscode;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}