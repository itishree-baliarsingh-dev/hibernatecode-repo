package com.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class ItemizedBill implements Serializable {
	private int billNo;
	private long localMessages;
	private long internationalMessages;
	private long localVoiceMinutes;
	private long internationalVoiceMinutes;
	private double previousDueAmount;
	private Bill bill;
}
