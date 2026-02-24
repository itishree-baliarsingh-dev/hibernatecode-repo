package com.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Locker implements Serializable {
	private int lockerNo;
	private String dimensions;
	private String branchCode;
	private int keyNo;
	private String termsAndConditions;
	private double charges;

	private Account account;
}
