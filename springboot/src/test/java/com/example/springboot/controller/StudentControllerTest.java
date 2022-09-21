package com.example.springboot.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import javax.print.DocFlavor.SERVICE_FORMATTED;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.springboot.dto.StudentDto;
import com.example.springboot.entity.Student;
import com.example.springboot.response.StudentResponse;
import com.example.springboot.service.StudentServiceClass;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
	@InjectMocks
	StudentController controller;
	@Mock
    StudentServiceClass service;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

@Test
void testGetStudent() {
	StudentDto studentDto=new StudentDto();

	when(service.getStudent(100)).thenReturn(studentDto);
	ResponseEntity<StudentResponse> responseEntity = controller.getStudent(100);
	assertNotNull(responseEntity);
	assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);


}

}
