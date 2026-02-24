package com.entities;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.ForeignGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "itemized_bill")
@GenericGenerator(name = "foreigngen", type = ForeignGenerator.class, parameters = {
		@org.hibernate.annotations.Parameter(name = "property", value = "bill") })
public class ItemizedBill implements Serializable {
	@Id
	@Column(name = "bill_no")
	@GeneratedValue(generator = "foreigngen")
	private int billNo;
	@Column(name = "local_messages")
	private long localMessages;
	@Column(name = "international_messages")
	private long internationalMessages;
	@Column(name = "local_voice_mins")
	private long localVoiceMinutes;
	@Column(name = "international_voice_mins")
	private long internationalVoiceMinutes;
	@Column(name = "previous_due_amt")
	private double previousDueAmount;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Bill bill;
}
