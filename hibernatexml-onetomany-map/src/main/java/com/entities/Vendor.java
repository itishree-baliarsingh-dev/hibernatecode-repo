package com.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

import lombok.Data;

@Data
public class Vendor implements Serializable {
	private int vendorNo;
    private String vendorName;
    private LocalDate establishedDate;
    private String contactNo;
    private String emailAddress;
    
    private Map<String, Project> allocatedProjects;
}
