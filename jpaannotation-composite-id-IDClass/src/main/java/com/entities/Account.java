package com.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
@IdClass(AccountPK.class)
public class Account implements Serializable {
	@Id
	@Column(name = "account_nbr")
	private String accountNumber;
	@Id
	@Column(name = "ifsc_code")
	private String ifscCode;
	@Column(name = "account_holder_nm")
	private String accountHolderName;
	@Column(name = "account_type")
	private String accountType;
	private double balance;
}
