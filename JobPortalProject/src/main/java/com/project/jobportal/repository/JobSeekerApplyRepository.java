package com.project.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.jobportal.entity.JobPostActivity;
import com.project.jobportal.entity.JobSeekerApply;
import com.project.jobportal.entity.JobSeekerProfile;

@Repository
public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply, Integer> {

    List<JobSeekerApply> findByUserId(JobSeekerProfile userId);

    List<JobSeekerApply> findByJob(JobPostActivity job);
}