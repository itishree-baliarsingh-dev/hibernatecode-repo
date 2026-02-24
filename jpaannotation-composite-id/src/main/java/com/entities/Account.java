package com.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account implements Serializable {
	@EmbeddedId
	private AccountPK id;
	@Column(name = "account_holder_nm")
	private String accountHolderName;
	@Column(name = "account_type")
	private String accountType;
	private double balance;
}
