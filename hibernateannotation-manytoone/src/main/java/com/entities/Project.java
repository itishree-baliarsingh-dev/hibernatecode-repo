package com.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project implements Serializable {
	@Id
	@Column(name = "project_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectNo;
	private String title;
	@Column(name = "estimated_duration")
	private int estimatedDuration;
	@Column(name = "started_dt")
	private LocalDate startedDate;
	@Column(name = "client_nm")
	private String clientName;

}
