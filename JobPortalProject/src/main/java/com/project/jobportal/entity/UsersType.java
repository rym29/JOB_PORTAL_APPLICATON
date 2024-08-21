package com.project.jobportal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_type")
public class UsersType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userTypeId;

	private String userTypeName;

	@OneToMany(targetEntity = Users.class, cascade = CascadeType.ALL, mappedBy = "userTypeId", fetch = FetchType.EAGER)
	private List<Users> users;
}
