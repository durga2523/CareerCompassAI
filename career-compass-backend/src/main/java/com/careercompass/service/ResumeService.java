package com.careercompass.service;

import com.careercompass.dto.AIResumeAnalysisResponse;
import com.careercompass.dto.JobDescriptionRequest;
import com.careercompass.dto.JobMatchResponse;
import com.careercompass.dto.ResumeDetailsResponse;
import com.careercompass.entity.Resume;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ResumeService {

    //Resume saveResume(Resume resume);
    Resume uploadResume(
            MultipartFile file,
            HttpServletRequest request
    );
    ResumeDetailsResponse getResumeDetails(Long id);

    List<Resume> getAllResumes();

    Optional<Resume> getResumeById(Long id);

    List<Resume> getResumesByUser(Long userId);

    AIResumeAnalysisResponse getSavedAnalysis(Long resumeId);

    void deleteResume(Long id);

    JobMatchResponse matchJobDescription(
            Long id,
            JobDescriptionRequest request);

    AIResumeAnalysisResponse analyzeResume(Long resumeId);
}