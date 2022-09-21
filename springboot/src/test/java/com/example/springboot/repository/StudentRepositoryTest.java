package com.example.springboot.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.springboot.entity.Student;

@DataJpaTest
class StudentRepositoryTest {
	@Autowired
	private StudentRepository repository;
@Test
	void testSaveStudent() {
		Student student=new Student();
		student.setStdId(100);
		student.setStdName("chandu");
		student.setStdAddress("akividu");
		student.setStdPass("qwerty");
		Student student2 = repository.save(student);
		assertThat(student2.getStdName()).isEqualTo("chandu");
	}
}
