package com.example.springboot.response;

import org.springframework.stereotype.Component;

import com.example.springboot.entity.Student;

import lombok.Data;

@Data
@Component
public class StudentResponse {

	private Boolean isError;
	private String msg;
	private Object object;
	
}
