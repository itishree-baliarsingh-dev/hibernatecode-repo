package com.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AccountPK implements Serializable {
	@Column(name = "account_nbr")
	private String accountNumber;
	@Column(name = "ifsc_code")
	private String ifscCode;
}
