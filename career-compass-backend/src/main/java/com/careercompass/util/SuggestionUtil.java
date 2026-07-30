package com.careercompass.util;

import java.util.ArrayList;
import java.util.List;

public class SuggestionUtil {

    public static List<String> generateSuggestions(List<String> missingSkills) {

        List<String> suggestions = new ArrayList<>();

        for (String skill : missingSkills) {

            switch (skill.toLowerCase()) {

                case "docker":
                    suggestions.add("Learn Docker and deploy a Spring Boot application.");
                    break;

                case "aws":
                    suggestions.add("Complete AWS Cloud Practitioner certification.");
                    break;

                case "rest api":
                    suggestions.add("Build REST APIs using Spring Boot.");
                    break;

                case "git":
                    suggestions.add("Practice Git branching and GitHub collaboration.");
                    break;

                default:
                    suggestions.add("Improve your knowledge of " + skill + ".");
            }
        }

        return suggestions;
    }
}