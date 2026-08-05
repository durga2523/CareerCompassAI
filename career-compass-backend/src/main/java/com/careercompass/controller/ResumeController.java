package com.careercompass.controller;

import com.careercompass.dto.AIResumeAnalysisResponse;
import com.careercompass.dto.JobDescriptionRequest;
import com.careercompass.dto.JobMatchResponse;
import com.careercompass.dto.ResumeDetailsResponse;
import com.careercompass.entity.Resume;
import com.careercompass.service.ResumeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

//    @PostMapping
//    public Resume saveResume(@RequestBody Resume resume) {
//        return resumeService.saveResume(resume);
//    }

    @GetMapping
    public List<Resume> getAllResumes() {
        return resumeService.getAllResumes();
    }

    @GetMapping("/user/{userId}")
    public List<Resume> getResumesByUser(@PathVariable Long userId) {
        return resumeService.getResumesByUser(userId);
    }

    @GetMapping("/{id}/analysis")
    public AIResumeAnalysisResponse getSavedAnalysis(
            @PathVariable Long id) {

        return resumeService.getSavedAnalysis(id);

    }

    @GetMapping("/{id}")
    public Resume getResumeById(@PathVariable Long id) {

        return resumeService.getResumeById(id)
                .orElseThrow(() ->
                        new RuntimeException("Resume not found with ID : " + id));
    }

    @DeleteMapping("/{id}")
    public String deleteResume(@PathVariable Long id) {
        resumeService.deleteResume(id);
        return "Resume deleted successfully!";
    }

    @PostMapping("/upload")
    public Resume uploadResume(
            @RequestParam("file") MultipartFile file,
            HttpServletRequest request) {

        return resumeService.uploadResume(file, request);
    }

    @GetMapping("/{id}/details")
    public ResumeDetailsResponse getResumeDetails(@PathVariable Long id) {
        return resumeService.getResumeDetails(id);
    }

    @PostMapping("/{id}/job-match")
    public ResponseEntity<JobMatchResponse> matchJobDescription(
            @PathVariable Long id,
            @RequestBody JobDescriptionRequest request) {

        return ResponseEntity.ok(
                resumeService.matchJobDescription(id, request)
        );
        }
    @PostMapping("/{id}/ai-analysis")
    public AIResumeAnalysisResponse analyzeResponse(@PathVariable Long id){
        return resumeService.analyzeResume(id);
    }
}