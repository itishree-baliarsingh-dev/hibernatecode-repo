package com.cid.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Person implements Serializable {
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String mobileNo;
	private String emailAddress;

}
