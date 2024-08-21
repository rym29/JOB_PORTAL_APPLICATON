package com.project.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.jobportal.entity.UsersType;

@Repository
public interface UsersTypeRepository extends JpaRepository<UsersType, Integer> {

}
