package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	public Student findByStdId(Integer id);
}
