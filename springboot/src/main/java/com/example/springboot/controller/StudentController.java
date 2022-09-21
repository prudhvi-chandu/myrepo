package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dto.StudentDto;
import com.example.springboot.response.StudentResponse;
import com.example.springboot.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
@Autowired
	private StudentService service;
@PostMapping("/student")
public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentDto studentdto) {
	StudentResponse response=new StudentResponse();
	StudentDto student = service.addStudent(studentdto);
    if (student != null) {
		response.setIsError(false);
		response.setMsg("student added successfully");
		return new ResponseEntity<StudentResponse>(response,HttpStatus.OK);
	}else {
		response.setIsError(true);
		response.setMsg("student not added");
		return new ResponseEntity<StudentResponse>(response,HttpStatus.BAD_REQUEST);
	}
}
    @PutMapping("/student")
    public ResponseEntity<StudentResponse> updateStudent(@RequestBody StudentDto studentdto) {
    	StudentResponse response=new StudentResponse();
    	StudentDto student = service.updateStudent(studentdto);
        if (student != null) {
    		response.setIsError(false);
    		response.setMsg("student updated successfully");
    		return new ResponseEntity<StudentResponse>(response,HttpStatus.OK);
    	}else {
    		response.setIsError(true);
    		response.setMsg("student not updated");
    		return new ResponseEntity<StudentResponse>(response,HttpStatus.BAD_REQUEST);
    	}
    }
        @GetMapping("/student/{stdId}")
        public ResponseEntity<StudentResponse> getStudent(@PathVariable Integer stdId) {
        	StudentResponse response=new StudentResponse();
        	StudentDto student = service.getStudent(stdId);
            if (student != null) {
        		response.setIsError(false);
        		response.setMsg("student details found");
        		response.setObject(student);
        		return new ResponseEntity<StudentResponse>(response,HttpStatus.OK);
        	}else {
        		response.setIsError(true);
        		response.setMsg("student not updated");
        		return new ResponseEntity<StudentResponse>(response,HttpStatus.BAD_REQUEST);
        	}
        }
            @DeleteMapping("/student/{stdId}")
            public ResponseEntity<StudentResponse> deleteStudent(@PathVariable Integer stdId) {
            	StudentResponse response=new StudentResponse();
                if (service.deleteStudent(stdId)) {
            		response.setIsError(false);
            		response.setMsg("student deleted successfully");
            		return new ResponseEntity<StudentResponse>(response,HttpStatus.OK);
            	}else {
            		response.setIsError(true);
            		response.setMsg("student not deleted");
            		return new ResponseEntity<StudentResponse>(response,HttpStatus.BAD_REQUEST);
            	}
            }
                @GetMapping("/student")
                public ResponseEntity<StudentResponse> SeeAll() {
                	StudentResponse response=new StudentResponse();
                	List<StudentDto> students = service.seeAll();
                    if (students != null) {
                		response.setIsError(false);
                		response.setMsg("student details found");
                		response.setObject(students);
                		return new ResponseEntity<StudentResponse>(response,HttpStatus.OK);
                	}else {
                		response.setIsError(true);
                		response.setMsg("student not updated");
                		return new ResponseEntity<StudentResponse>(response,HttpStatus.BAD_REQUEST);
                	}
                }
        
}

