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

        System.out.println("========== AI SERVICE START ==========");

        System.out.println("Resume Text:");
        System.out.println(resumeText);

        String prompt = """
Analyze this resume in one sentence.

Resume:
%s
""".formatted(resumeText);

        String response = chatClient.prompt()
                .user(prompt)
                .call()
                .content();

        System.out.println("AI Response:");
        System.out.println(response);

        System.out.println("========== AI SERVICE END ==========");

        return null;
    }

}