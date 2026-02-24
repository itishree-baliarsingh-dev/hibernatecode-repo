package com.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class MedicalInsurancePlan extends InsurancePlan {
	private int copay;
	private String coverageType;
}
