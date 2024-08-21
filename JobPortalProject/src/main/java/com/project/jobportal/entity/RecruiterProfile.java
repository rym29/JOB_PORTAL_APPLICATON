package com.project.jobportal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recruiter_profile")
public class RecruiterProfile {

	public RecruiterProfile(Users users) {

		this.userId = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userAccountId;
	@OneToOne
	@JoinColumn(name = "user_account_id")
	@MapsId
	private Users userId;
	private String firstname;
	private String lastname;
	private String city;
	private String state;
	private String country;
	private String company;
	@Column(nullable = true, length = 64)
	private String profilePhoto;

	@Transient
	public String getPhotosImagePath() {
		if (profilePhoto == null)
			return null;
		return "/photos/recruiter/" + userAccountId + "/" + profilePhoto;
	}

}
