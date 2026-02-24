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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode(exclude = { "subscriptions", "serialNo", "price" })
@ToString(exclude = { "subscriptions" })
@Entity
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "settopbox")
public class SetTopBox implements Serializable {
	@Id
	@Column(name = "serial_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serialNo;
	private String manufacturer;
	@Column(name = "box_type")
	private String boxType;
	private double price;

	@OneToMany
	@JoinColumn(name = "serial_no", unique = true, nullable = true)
	private Set<Subscription> subscriptions;
}
