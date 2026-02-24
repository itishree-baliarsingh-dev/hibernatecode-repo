package com.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Player implements Serializable {
	private int playerNo;
    private String playerName;
    private int age;
    private String gender;
    private String mobileNo;
    private String emailAddress;
    private float height;
    private float weight;
    private String sportType;

    private Coach coach;
}
