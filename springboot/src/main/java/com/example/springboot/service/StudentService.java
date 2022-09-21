package com.example.springboot.service;

import java.util.List;

import com.example.springboot.dto.StudentDto;
import com.example.springboot.entity.Student;


public interface StudentService {

	public StudentDto addStudent(StudentDto studentDto);
	
	public StudentDto updateStudent(StudentDto studentDto);

	public StudentDto getStudent(Integer id);

	public boolean deleteStudent(Integer id);
	
	public List<StudentDto> seeAll();
	

}
