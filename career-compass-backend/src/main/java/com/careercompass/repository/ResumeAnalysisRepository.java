package com.careercompass.repository;

import com.careercompass.entity.Resume;
import com.careercompass.entity.ResumeAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResumeAnalysisRepository
        extends JpaRepository<ResumeAnalysis, Long> {

    Optional<ResumeAnalysis> findByResume(Resume resume);

}