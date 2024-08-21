package com.project.jobportal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_profile")

public class JobSeekerProfile {
	public JobSeekerProfile(Users users) {
		// TODO Auto-generated constructor stub
		this.userId = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userAccountId;
	@OneToOne
	@JoinColumn(name = "user_account_id")
	@MapsId
	private Users userId;

	private String firstname;
	private String lastname;
	private String city;
	private String state;
	private String country;
	@Column(nullable = true, length = 64)
	private String profilePhoto;
	private String resume;
	private String workAuthorization;
	private String employeementType;

	@Transient
	public String getPhotosImagePath() {
		if (profilePhoto == null || userAccountId == null)
			return null;
		return "/photos/candidate/" + userAccountId + "/" + profilePhoto;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "jobSeekerProfile", targetEntity = Skills.class)
	private List<Skills> skills;
}
