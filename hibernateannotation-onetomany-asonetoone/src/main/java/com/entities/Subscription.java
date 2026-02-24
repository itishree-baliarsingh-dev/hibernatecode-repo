package com.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode(exclude = { "subscriptionNo", "setTopBox" })
@ToString
@Entity
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subscription")
public class Subscription implements Serializable {
	@Id
	@Column(name = "subscription_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subscriptionNo;
	@Column(name = "subscriber_nm")
	private String subscriberName;
	private String provider;
	private String plan;
	@Column(name = "monthly_charges")
	private double monthlyCharges;

	@ManyToOne
	@JoinColumn(name = "serial_no", unique = true, nullable = true)
	private SetTopBox setTopBox;
}
