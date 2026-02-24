package com.entities;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Trip implements Serializable {
	private int tripNo;
	private String source;
	private String destination;
	private String tripName;
	private int days;
	private LocalDate startDate;
	private LocalDate endDate;
	private double tripCost;
}
