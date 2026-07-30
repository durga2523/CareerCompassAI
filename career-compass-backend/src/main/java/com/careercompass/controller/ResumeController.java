package com.careercompass.controller;

import com.careercompass.dto.*;
import com.careercompass.entity.Resume;
import com.careercompass.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

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
            @RequestParam("userId") Long userId) {

        return resumeService.uploadResume(file, userId);
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