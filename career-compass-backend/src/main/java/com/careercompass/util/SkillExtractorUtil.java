package com.careercompass.util;

import java.util.ArrayList;
import java.util.List;

public class SkillExtractorUtil {

    private static final String[] SKILLS = {

            "Java",
            "SpringBoot",
            "MySQL",
            "React",
            "Angular",
            "HTML",
            "CSS",
            "JavaScript",
            "TypeScript",
            "Git",
            "GitHub",
            "Docker",
            "Hibernate",
            "JPA",
            "REST API",
            "Microservices",
            "Python",
            "C",
            "C++"
    };

    public static List<String> extractSkills(String resumeText) {

        List<String> foundSkills = new ArrayList<>();

        for (String skill : SKILLS) {

            if (resumeText.toLowerCase().contains(skill.toLowerCase())) {
                foundSkills.add(skill);
            }
        }

        return foundSkills;
    }
}