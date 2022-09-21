package com.example.springboot.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class StudentDtoTest extends Mockito{
    ObjectMapper mapper=new ObjectMapper();
    
    String json="{\"stdId\":100,\"stdName\":\"chandu\",\"stdAddress\":\"Akividu\",\"stdPass\":\"qwerty\"}\r\n"
    		+ "";
    @Test
	void serialize() throws JsonProcessingException {
		StudentDto dto=new StudentDto();
		dto.setStdId(100);
		dto.setStdName("chandu");
		dto.setStdAddress("Akividu");
		dto.setStdPass("qwerty");
		
		//System.out.println(mapper.writeValueAsString(dto));
	    String object = "mapper.readValue(json, StudentDto.class)";
	    assertThat(json.equals(object));
    
    }
    @Test
    void deserialize() throws JsonMappingException, JsonProcessingException{
    	StudentDto studentDto = mapper.readValue(json, StudentDto.class);
    	assertThat(studentDto.getStdName().equals("chandu"));
    }

}
