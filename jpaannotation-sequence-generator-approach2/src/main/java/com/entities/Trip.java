package com.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "trip")
public class Trip implements Serializable {
	@Id
	@Column(name = "trip_no")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
	@SequenceGenerator(name = "seq_gen", sequenceName = "trip_seq", allocationSize = 1)
	private int tripNo;
	private String source;
	private String destination;
	@Column(name = "trip_nm")
	private String tripName;
	private int days;
	@Column(name = "start_dt")
	private LocalDate startDate;
	@Column(name = "end_dt")
	private LocalDate endDate;
	@Column(name = "trip_cost")
	private double tripCost;
}
