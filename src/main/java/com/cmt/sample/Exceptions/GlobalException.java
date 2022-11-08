package com.cmt.sample.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cmt.sample.APIResponse.APIResponse;



@ControllerAdvice
public class GlobalException {
	APIResponse apiresponse;
	public GlobalException(APIResponse apiresponse) {
		super();
		this.apiresponse = apiresponse;
	}
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<APIResponse> handleResourceNotFoundException(ResourceNotFound exception){
		Errordetails errordetails=new Errordetails(exception.getMessage(),HttpStatus.NOT_FOUND.value());
		apiresponse.setErrors(errordetails);
		apiresponse.setData1(null);
	    apiresponse.setStatus(HttpStatus.NOT_FOUND.value());
     	return ResponseEntity.status(HttpStatus.OK.value()).body(apiresponse);
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<APIResponse> handleGlobalException(Exception exception){
		Errordetails errordetails=new Errordetails(exception.getMessage(),HttpStatus.NOT_FOUND.value());
		apiresponse.setErrors(errordetails);
		apiresponse.setData1(null);
		apiresponse.setStatus(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.OK.value()).body(apiresponse);
		
	}
}




