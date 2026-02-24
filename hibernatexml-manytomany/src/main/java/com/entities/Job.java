package com.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
public class Job implements Serializable {
	private int jobNo;
	private String jobTitle;
	private String description;
	private int experience;
	private String qualification;
	private String company;
}
