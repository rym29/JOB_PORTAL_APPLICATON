package com.project.jobportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jobportal.entity.UsersType;
import com.project.jobportal.repository.UsersTypeRepository;
import java.util.*;

@Service
public class UsersTypeService {

	private final UsersTypeRepository utr;

	@Autowired
	public UsersTypeService(UsersTypeRepository utr) {
		this.utr = utr;
	}

	public List<UsersType> getAll() {
		return utr.findAll();

	}
}
