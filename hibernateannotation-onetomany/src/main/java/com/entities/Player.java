package com.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "player")
public class Player implements Serializable {
	@Id
	@Column(name = "player_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerNo;
	@Column(name = "player_nm")
	private String playerName;
	private int age;
	private String gender;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "email_address")
	private String emailAddress;
	private float height;
	private float weight;
	@Column(name = "sport_type")
	private String sportType;

}
