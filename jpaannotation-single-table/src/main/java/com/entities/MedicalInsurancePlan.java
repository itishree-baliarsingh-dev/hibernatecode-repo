package com.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("MedicalInsurancePlan")
public class MedicalInsurancePlan extends InsurancePlan {
	private int copay;
	@Column(name = "coverage_type")
	private String coverageType;
}
