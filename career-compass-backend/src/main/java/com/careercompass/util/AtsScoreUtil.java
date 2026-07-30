package com.careercompass.util;

import com.careercompass.dto.AtsScoreResponse;
import com.careercompass.enums.ResumeDomain;

import java.util.ArrayList;
import java.util.List;

public class AtsScoreUtil {

    public static AtsScoreResponse calculateScore(
            ResumeDomain domain,
            List<String> detectedSkills) {

        List<String> requiredSkills = DomainSkillsUtil.getSkills(domain);

        List<String> strengths = new ArrayList<>(detectedSkills);
        List<String> missingSkills = new ArrayList<>();
        List<String> suggestions = new ArrayList<>();

        for (String skill : requiredSkills) {

            if (!detectedSkills.contains(skill)) {
                missingSkills.add(skill);
                suggestions.add("Learn " + skill);
            }
        }

        int score = 0;

        if (!requiredSkills.isEmpty()) {
            score = (detectedSkills.size() * 100) / requiredSkills.size();
        }

        if (score > 100) {
            score = 100;
        }

        return AtsScoreResponse.builder()
                .score(score)
                .strengths(strengths)
                .missingSkills(missingSkills)
                .suggestions(suggestions)
                .build();
    }
}