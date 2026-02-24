package com.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Branch implements Serializable {
	private static final long serialVersionUID = -1815583635846834936L;
	private int branchNo;
	private String branchName;
	private String ifscCode;
	private String location;
	private int zipcode;
	private String contactNo;
}
