package com.example.springboot.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.springboot.dto.StudentDto;
import com.example.springboot.entity.Student;
import com.example.springboot.exception.CustomException;
import com.example.springboot.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
class StudentServiceClassTest {
	@Mock
	private StudentRepository repository;
	@InjectMocks
	private StudentServiceClass service;

	@BeforeEach
	void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getStudentTest() {

		Student student = new Student();
		student.setStdId(100);
		student.setStdName("chandu");
		student.setStdAddress("akividu");
		student.setStdPass("qwerty");

		when(repository.findByStdId(100)).thenReturn(student);

		StudentDto studentDto = service.getStudent(100);
		assertNotNull(studentDto);
		assertEquals("chandu", studentDto.getStdName());
	}

	@Test
	void addStudentTest() {

		Student student = new Student();
		student.setStdId(100);
		student.setStdName("chandu");
		student.setStdAddress("akividu");
		student.setStdPass("qwerty");
		when(repository.save(student)).thenReturn(student);
		StudentDto dto = new StudentDto();
		dto.setStdId(100);
		dto.setStdName("chandu");
		dto.setStdAddress("akividu");
		dto.setStdPass("qwerty");
		StudentDto studentDto = service.addStudent(dto);
		assertNotNull(studentDto);
		assertEquals("chandu", studentDto.getStdName());
	}
	@Test
	void testStudent_exception() {
		when(repository.findByStdId(100)).thenReturn(null);
		assertThrows(CustomException.class, ()->{ service.getStudent(100);
		});
		}
		
	}

