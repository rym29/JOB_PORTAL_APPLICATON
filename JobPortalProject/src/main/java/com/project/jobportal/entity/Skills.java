package com.project.jobportal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skills")
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)

	@JoinColumn(name = "job_seeker_profiles")
	private JobSeekerProfile jobSeekerProfile;

	private String name;

	private String experienceLevel;

	private String yearsOfExperience;

	public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
		// TODO Auto-generated method stub
		
	}

}
