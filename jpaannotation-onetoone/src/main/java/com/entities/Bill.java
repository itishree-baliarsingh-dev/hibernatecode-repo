package com.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "bill")
public class Bill implements Serializable {
	@Id
	@Column(name = "bill_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billNo;
	@Column(name = "bill_generated_dt")
	private LocalDate billGeneratedDate;
	@Column(name = "customer_nm")
	private String customerName;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "due_dt")
	private LocalDate dueDate;
	@Column(name = "bill_amt")
	private double billAmount;
}
