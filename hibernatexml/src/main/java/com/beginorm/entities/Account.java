package com.beginorm.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Account implements Serializable {
	private static final long serialVersionUID = -3571981754327422695L;
	private int accountNo;
	private String accountHolderName;
	private String accountType;
	private String ifscCode;
	private double balance;
}
