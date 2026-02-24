package com.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class InsurancePlan implements Serializable {
	protected int planNo;
	protected String planName;
	protected int tenure;
	protected double premiumAmount;
	protected double insurredAmount;
	protected String status;
}
