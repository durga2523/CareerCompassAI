package com.careercompass.service.ai.impl;

import com.careercompass.dto.AIResumeAnalysisResponse;
import com.careercompass.service.ai.AIService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIServiceImpl implements AIService {

    private final ChatClient chatClient;

    public AIServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Override
    public AIResumeAnalysisResponse analyzeResume(String resumeText) {

        String prompt = """
You are an expert ATS Resume Analyzer.

Analyze the following resume.

Return ONLY a valid JSON object.

The JSON format MUST be exactly:

{
  "atsScore": 0,
  "resumeSummary": "",
  "detectedSkills": [],
  "missingSkills": [],
  "recommendations": []
}

Rules:
1. atsScore must be between 0 and 100.
2. resumeSummary must contain 2-3 sentences.
3. detectedSkills must contain only skills found in the resume.
4. missingSkills must contain useful industry skills that are missing.
5. recommendations must contain 5 actionable suggestions.
6. Do NOT return markdown.
7. Do NOT wrap the JSON inside ```json```.
8. Return JSON only.

Resume:

%s
""".formatted(resumeText);

        try {

            AIResumeAnalysisResponse response = chatClient.prompt()
                    .user(prompt)
                    .call()
                    .entity(AIResumeAnalysisResponse.class);

            return response;

        } catch (Exception e) {

            System.out.println("========== AI ERROR ==========");
            e.printStackTrace();

            throw new RuntimeException("Failed to generate AI analysis.", e);
        }
    }
}