package com.careercompass.service.ai;

import com.careercompass.dto.AIResumeAnalysisResponse;

public interface AIService {

    AIResumeAnalysisResponse analyzeResume(String resumeText);
}