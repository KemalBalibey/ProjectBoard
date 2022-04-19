package com.projectboard.projectboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor 
@NoArgsConstructor
@Data
@Table(name ="project_board" )
public class ProjectTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@NotBlank(message = "Summary boş bırakılamaz.")
	@Column
	private String summary;
	
	@Column(name="acceptance_criteria")
	private String acceptanceCriteria;
	
	@Column
	private String status;

}
