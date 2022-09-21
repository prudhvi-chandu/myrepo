package com.example.springboot.exception;

public class CustomException extends RuntimeException {

	private String msg;

	public CustomException(String msg) {
		this.msg = msg;
	}
    	
	@Override
	public String getMessage() {
		return this.msg;
	}
}
