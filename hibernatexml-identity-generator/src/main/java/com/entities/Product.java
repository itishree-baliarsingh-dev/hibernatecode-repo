package com.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable {
	private int productNo; 
	private String productName; 
}
