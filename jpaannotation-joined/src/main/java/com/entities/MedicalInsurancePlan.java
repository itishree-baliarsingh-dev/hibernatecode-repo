package com.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "medical_insurance_plan")
@PrimaryKeyJoinColumn(name = "medical_insurance_plan_no")
public class MedicalInsurancePlan extends InsurancePlan {
	private int copay;
	@Column(name = "coverage_type")
	private String coverageType;
}
