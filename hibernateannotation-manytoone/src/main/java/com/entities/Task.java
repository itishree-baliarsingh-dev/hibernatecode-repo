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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task implements Serializable {
	@Id
	@Column(name = "task_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskNo;
	@Column(name = "task_nm")
	private String taskName;
	@Column(name = "story_points")
	private int storyPoints;
	@Column(name = "assigned_to")
	private String assignedTo;

	@ManyToOne
	@JoinColumn(name = "project_no")
	private Project project;
}
