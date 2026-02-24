package com.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("AccidentalInsurancePlan")
public class AccidentalInsurancePlan extends InsurancePlan {
	@Column(name = "disability_coverage_percentage")
	private int disabilityCoveragePercentage;
	@Column(name = "international_coverage")
	private boolean internationalCoverage;
}
