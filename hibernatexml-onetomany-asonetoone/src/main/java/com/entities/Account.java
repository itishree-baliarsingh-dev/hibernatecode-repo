package com.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Account implements Serializable {
	private int accountNo;
	private String accountHolderName;
	private String accountType;
	private String ifscCode;
	private double balance;
}
