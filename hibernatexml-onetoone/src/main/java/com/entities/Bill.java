package com.entities;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Bill implements Serializable {
	private int billNo;
	private LocalDate billGeneratedDate;
	private String customerName;
	private String mobileNo;
	private LocalDate dueDate;
	private double billAmount;
}
