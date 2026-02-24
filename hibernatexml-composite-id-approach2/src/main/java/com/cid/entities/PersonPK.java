package com.cid.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class PersonPK implements Serializable{
	private String firstName;
	private String lastName;
}
