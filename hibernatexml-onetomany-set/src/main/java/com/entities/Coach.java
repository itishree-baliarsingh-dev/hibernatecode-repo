package com.entities;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class Coach implements Serializable {
	private int coachNo;
    private String coachName;
    private int age;
    private String gender;
    private int experience;
    private String mobileNo;
    private String emailAddress;
    
    private Set<Player> players;
}
