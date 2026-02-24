package com.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book implements Serializable {
	private static final long serialVersionUID = -6238692608574724977L;
	@Id
	private int isbn;
	@Basic
	private String title;
	private String author;
	private String publisher;
	@Column(name = "published_dt")
	private LocalDate publishedDate;
	private double price;
}
