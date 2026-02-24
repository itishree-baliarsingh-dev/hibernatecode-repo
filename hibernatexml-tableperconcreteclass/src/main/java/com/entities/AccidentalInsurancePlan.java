package com.entities;

import lombok.Data;

@Data
public class AccidentalInsurancePlan extends InsurancePlan {
	private int disabilityCoveragePercentage;
	private boolean internationalCoverage;
}
