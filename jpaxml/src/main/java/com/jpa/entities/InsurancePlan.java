package com.jpa.entities;

import java.io.Serializable;

import lombok.Data;
@Data
public class InsurancePlan implements Serializable {
	private static final long serialVersionUID = -7719609288998030553L;
	private int planNo;
	private String planName;
	private String planType;
	private int minTenure;
	private double minInsurredAmount;
	private int minAge;
	private double maturityBonusPercentage;
}
