package com.careercompass.controller;

import com.careercompass.dto.AIResumeAnalysisResponse;
import com.careercompass.service.ai.AIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/analyze")
    public AIResumeAnalysisResponse analyzeResume(@RequestBody String resumeText) {

        return aiService.analyzeResume(resumeText);

    }
}