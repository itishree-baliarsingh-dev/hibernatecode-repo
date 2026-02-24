package com.entities;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
public class Applicant implements Serializable {
	private int applicantNo;
	private String applicantName;
	private int experience;
	private String qualification;
	private String gender;
	private int age;

	private Set<Job> appliedJobs;
}
