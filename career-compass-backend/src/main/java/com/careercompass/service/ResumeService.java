package com.careercompass.service;

import com.careercompass.dto.*;
import com.careercompass.entity.Resume;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ResumeService {

    //Resume saveResume(Resume resume);
    Resume uploadResume(MultipartFile file, Long userId);
    ResumeDetailsResponse getResumeDetails(Long id);

    List<Resume> getAllResumes();

    Optional<Resume> getResumeById(Long id);

    void deleteResume(Long id);

    JobMatchResponse matchJobDescription(
            Long id,
            JobDescriptionRequest request);

    AIResumeAnalysisResponse analyzeResume(Long resumeId);
}