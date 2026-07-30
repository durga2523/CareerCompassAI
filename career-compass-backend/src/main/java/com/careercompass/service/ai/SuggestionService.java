package com.careercompass.service.ai;

import java.util.List;

public interface SuggestionService {

    List<String> generateSuggestions(
            List<String> missingSkills);
}