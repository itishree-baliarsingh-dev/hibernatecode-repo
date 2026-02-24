package com.entities;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Order implements Serializable {
	private int orderNo;
	private String customerName;
	private LocalDate orderedDate;
	private String mobileNo;
	private String emailAddress;
	private double amount;
}
