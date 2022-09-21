package com.example.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springboot.response.StudentResponse;

@ControllerAdvice
public class GlobalException {
@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> handleException(CustomException exception) {
		StudentResponse response=new StudentResponse();
		response.setIsError(true);
		response.setMsg(exception.getMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
}
