package com.careercompass.service.impl;

import com.careercompass.dto.*;
import com.careercompass.entity.Resume;
import com.careercompass.entity.ResumeAnalysis;
import com.careercompass.entity.User;
import com.careercompass.enums.ResumeDomain;
import com.careercompass.repository.ResumeAnalysisRepository;
import com.careercompass.repository.ResumeRepository;
import com.careercompass.repository.UserRepository;
import com.careercompass.service.FileStorageService;
import com.careercompass.service.ResumeService;
import com.careercompass.service.ai.*;
import com.careercompass.util.JwtUtil;
import com.careercompass.util.ListConverter;
import com.careercompass.util.PdfParserUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private SkillExtractionService skillExtractionService;

    @Autowired
    private DomainDetectionService domainDetectionService;

    @Autowired
    private AtsScoringService atsScoringService;

    @Autowired
    private JobMatchingService jobMatchingService;

    @Autowired
    private SuggestionService suggestionService;

    @Autowired
    private AIService aiService;

    @Autowired
    private ResumeAnalysisRepository resumeAnalysisRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Resume uploadResume(
            MultipartFile file,
            HttpServletRequest request) {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Missing or invalid Authorization header");
        }

        String token = authHeader.substring(7);

        String email = jwtUtil.extractEmail(token);

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found");
        }
        String filePath = fileStorageService.uploadFile(file);
        String resumeText = PdfParserUtil.extractText(file);
        Resume resume = Resume.builder()
                .fileName(file.getOriginalFilename())
                .fileType(file.getContentType())
                .filePath(filePath)
                .resumeText(resumeText)
                .uploadedAt(LocalDateTime.now())
                .user(user)
                .build();
       // ===== Extracted Resume Text =====



        List<String> skills =
                skillExtractionService.extractSkills(resumeText);
//        System.out.println("===== Skills =====");
//        skills.forEach(System.out::println);
//        System.out.println("===== Resume Text =====");


        return resumeRepository.save(resume);
    }
    @Override
    public List<Resume> getAllResumes() {

        return resumeRepository.findAll();
    }

    @Override
    public Optional<Resume> getResumeById(Long id) {

        return resumeRepository.findById(id);
    }

    @Override
    public List<Resume> getResumesByUser(Long userId) {

        return resumeRepository.findByUserIdOrderByUploadedAtDesc(userId);

    }

    @Override
    public void deleteResume(Long id) {

        resumeRepository.deleteById(id);
    }

    @Override
    public JobMatchResponse matchJobDescription(Long id,
                                                JobDescriptionRequest request) {

        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Resume not found"));

        // Read resume text
        String resumeText = PdfParserUtil.extractText(resume.getFilePath());

        // Extract resume skills
        List<String> resumeSkills =
                skillExtractionService.extractSkills(resumeText);

        // Extract JD skills
        List<String> jobSkills =
                        skillExtractionService.extractSkills(request.getJobDescription());

        // Compare
        return jobMatchingService.compareSkills(
                resumeSkills,
                jobSkills
        );
    }

    @Override
    public AIResumeAnalysisResponse analyzeResume(Long resumeId) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() ->
                        new RuntimeException("Resume not found"));

//        System.out.println("========== RESUME SERVICE ==========");
//        System.out.println("Resume ID : " + resumeId);
//        System.out.println("Resume Text : ");
//        System.out.println(resume.getResumeText());

        String resumeText = resume.getResumeText();

        AIResumeAnalysisResponse response =
                aiService.analyzeResume(resumeText);

        ResumeAnalysis analysis = resumeAnalysisRepository
                .findByResume(resume)
                .orElse(new ResumeAnalysis());

        analysis.setResume(resume);
        analysis.setAtsScore(response.getAtsScore());
        analysis.setResumeSummary(response.getResumeSummary());
        analysis.setDetectedSkills(
                ListConverter.toString(response.getDetectedSkills()));
        analysis.setMissingSkills(
                ListConverter.toString(response.getMissingSkills()));
        analysis.setRecommendations(
                ListConverter.toString(response.getRecommendations()));

        resumeAnalysisRepository.save(analysis);

        return response;
    }

    @Override
    public AIResumeAnalysisResponse getSavedAnalysis(Long resumeId) {

//        System.out.println("GET SAVED ANALYSIS CALLED");
//        System.out.println("Resume ID = " + resumeId);

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() ->
                        new RuntimeException("Resume not found"));

        ResumeAnalysis analysis = resumeAnalysisRepository
                .findByResume(resume)
                .orElseThrow(() ->
                        new RuntimeException("Analysis not found"));

        return AIResumeAnalysisResponse.builder()
                .atsScore(analysis.getAtsScore())
                .resumeSummary(analysis.getResumeSummary())
                .detectedSkills(
                        ListConverter.toList(
                                analysis.getDetectedSkills()))
                .missingSkills(
                        ListConverter.toList(
                                analysis.getMissingSkills()))
                .recommendations(
                        ListConverter.toList(
                                analysis.getRecommendations()))
                .build();
    }

    @Override
    public ResumeDetailsResponse getResumeDetails(Long id) {

        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Resume not found"));

     //  String resumeText = PdfParserUtil.extractText(resume.getFilePath());

        String resumeText = resume.getResumeText();

        ResumeDomain domain = domainDetectionService.detectDomain(resumeText);
        System.out.println("Detected Domain : " + domain);

        List<String> skills =
                skillExtractionService.extractSkills(resumeText);

        AtsScoreResponse ats =
                atsScoringService.calculateScore(domain, skills);

//        System.out.println("===== ATS SCORE =====");
//        System.out.println("Score : " + ats.getScore());

 //       System.out.println("Strengths:");
        ats.getStrengths().forEach(System.out::println);

//        System.out.println("Missing Skills:");
        ats.getMissingSkills().forEach(System.out::println);

        return ResumeDetailsResponse.builder()
                .id(resume.getId())
                .fileName(resume.getFileName())
                .fileType(resume.getFileType())
                .filePath(resume.getFilePath())
                .resumeText(resumeText)
                .skills(skills)
                .build();
    }
}