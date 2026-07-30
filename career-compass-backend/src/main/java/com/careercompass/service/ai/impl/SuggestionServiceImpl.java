package com.careercompass.service.ai.impl;

import com.careercompass.service.ai.SuggestionService;
import com.careercompass.util.SuggestionUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionServiceImpl
        implements SuggestionService {

    @Override
    public List<String> generateSuggestions(
            List<String> missingSkills) {

        return SuggestionUtil.generateSuggestions(missingSkills);
    }
}