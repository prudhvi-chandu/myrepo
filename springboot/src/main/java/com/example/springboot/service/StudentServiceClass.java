package com.example.springboot.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.mapping.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.StudentDto;
import com.example.springboot.entity.Student;
import com.example.springboot.exception.CustomException;
import com.example.springboot.repository.StudentRepository;

@Service
public class StudentServiceClass implements StudentService {
	@Autowired
	private StudentRepository dao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public StudentDto addStudent(StudentDto studentDto) {
		Student student = new Student();
		BeanUtils.copyProperties(studentDto, student);
		dao.save(student);
		return studentDto;
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto) {
		Student student = dao.findByStdId(studentDto.getStdId());
		if (student != null) {
			BeanUtils.copyProperties(studentDto, student);
			dao.save(student);
			return studentDto;
		} else {
			throw new CustomException("student not found");
		}
	}

	@Override
	public StudentDto getStudent(Integer id) {
		Student student = dao.findByStdId(id);
		if (student != null) {
			StudentDto studentDto = new StudentDto();
			BeanUtils.copyProperties(student, studentDto);
			return studentDto;
		} else {
			throw new CustomException("student not found");
		}
	}

	@Override
	public boolean deleteStudent(Integer id) {
		Student student = dao.findByStdId(id);
		dao.delete(student);
		return true;
	}

	@Override
	public List<StudentDto> seeAll() {
		return dao.findAll().stream().map(this::convert).collect(Collectors.toList());
	}
	
	public StudentDto convert(Student findAll) {
		StudentDto studenDto=new StudentDto();
		mapper.map(findAll, studenDto);
        return studenDto;
	}

}
