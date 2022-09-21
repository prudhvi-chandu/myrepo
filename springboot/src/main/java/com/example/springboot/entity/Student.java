package com.example.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	private Integer stdId;
	private String stdName;
	private String stdAddress;
	private String stdPass;

}