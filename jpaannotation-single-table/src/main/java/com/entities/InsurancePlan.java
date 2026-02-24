package com.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "insurance_plan")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "insurance_plan_type")
@DiscriminatorValue("InsurancePlan")
public class InsurancePlan implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plan_no")
	protected int planNo;
	@Column(name = "plan_nm")
	protected String planName;
	protected int tenure;
	@Column(name = "premium_amt")
	protected double premiumAmount;
	@Column(name = "insurred_amt")
	protected double insurredAmount;
	protected String status;

}
