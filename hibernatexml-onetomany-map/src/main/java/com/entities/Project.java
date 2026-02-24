package com.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Project implements Serializable {
	private int projectNo;
    private String description;
    private String workType;
    private int estimatedDays;
    private double estimatedAmount;
}
