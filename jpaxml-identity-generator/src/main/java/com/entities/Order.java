package com.entities;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Order implements Serializable {
	private int orderNo;
	private String customerName;
	private LocalDate orderedDate;
	private double amount;
}
