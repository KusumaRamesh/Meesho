package com.cmt.sample.APIResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
@Component
public class APIResponse {
	private Integer status;
	private Object Data1;
	private Object errors;
	
	public APIResponse() {
		super();
		this.status = HttpStatus.OK.value();
		this.Data1 = Data1;
		this.errors = errors;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Object getData1() {
		return Data1;
	}
	public void setData1(Object data1) {
		this.Data1 = data1;
	}
	public Object getErrors() {
		return errors;
	}
	public void setErrors(Object errors) {
		this.errors = errors;
	}

}
