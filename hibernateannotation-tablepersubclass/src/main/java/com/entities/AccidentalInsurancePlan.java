package com.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accidental_insurance_plan")
@PrimaryKeyJoinColumn(name = "accidental_insurance_plan_no")
public class AccidentalInsurancePlan extends InsurancePlan {
	@Column(name = "disability_coverage_percentage")
	private int disabilityCoveragePercentage;
	@Column(name = "international_coverage")
	private boolean internationalCoverage;
}
