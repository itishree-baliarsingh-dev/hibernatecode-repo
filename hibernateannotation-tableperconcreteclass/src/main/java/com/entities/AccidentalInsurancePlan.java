package com.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accidental_insurance_plan")
public class AccidentalInsurancePlan extends InsurancePlan {
	@Column(name = "disability_coverage_percentage")
	private int disabilityCoveragePercentage;
	@Column(name = "international_coverage")
	private boolean internationalCoverage;
}
