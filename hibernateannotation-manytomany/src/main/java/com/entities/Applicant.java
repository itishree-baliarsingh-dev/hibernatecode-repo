package com.entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "applicant")
public class Applicant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "applicant_no")
	private int applicantNo;
	@Column(name = "applicant_nm")
	private String applicantName;
	private int experience;
	private String qualification;
	private String gender;
	private int age;

	@ManyToMany
	@JoinTable(name = "job_applicants", joinColumns = { @JoinColumn(name = "applicant_no") }, inverseJoinColumns = {
			@JoinColumn(name = "job_no") })
	private Set<Job> appliedJobs;
}
