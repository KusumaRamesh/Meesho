package com.cmt.sample.Exceptions;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFound exception,WebRequest request){
		Errordetails errordetails=new Errordetails(new Date(0),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<Errordetails>(errordetails,HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception,WebRequest request){
		Errordetails errordetails=new Errordetails(new Date(0),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<Errordetails>(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
}
}
	
