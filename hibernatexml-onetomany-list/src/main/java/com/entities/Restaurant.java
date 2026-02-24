package com.entities;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Restaurant implements Serializable {
	private int restaurantNo;
	private String restaurantName;
	private String cuisine;
	private int rating;
	private String contactNo;
	
	private List<Order> orders;
}
