package com.entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Coach implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coach_no")
	private int coachNo;
	@Column(name = "coach_nm")
	private String coachName;
	private int age;
	private String gender;
	private int experience;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "email_address")
	private String emailAddress;

	@OneToMany
	@JoinColumn(name = "coach_no", nullable = true)
	private Set<Player> players;
}
