package com.careercompass.util;

import com.careercompass.dto.JobMatchResponse;

import java.util.ArrayList;
import java.util.List;

public class JobMatcherUtil {

    public static JobMatchResponse compareSkills(
            List<String> resumeSkills,
            List<String> jobSkills) {

        List<String> matched = new ArrayList<>();
        List<String> missing = new ArrayList<>();

        for (String skill : jobSkills) {

            boolean found = resumeSkills.stream()
                    .anyMatch(s -> s.equalsIgnoreCase(skill));

            if (found) {
                matched.add(skill);
            } else {
                missing.add(skill);
            }
        }

        int score = 0;

        if (!jobSkills.isEmpty()) {
            score = (matched.size() * 100) / jobSkills.size();
        }

        return JobMatchResponse.builder()
                .matchScore(score)
                .matchedSkills(matched)
                .missingSkills(missing)
                .build();
    }
}