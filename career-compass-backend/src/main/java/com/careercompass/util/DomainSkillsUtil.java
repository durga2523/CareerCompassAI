package com.careercompass.util;

import com.careercompass.enums.ResumeDomain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DomainSkillsUtil {

    public static List<String> getSkills(ResumeDomain domain) {

        switch (domain) {

            case JAVA_DEVELOPER:
                return Arrays.asList(
                        "Java",
                        "Spring Boot",
                        "Hibernate",
                        "JPA",
                        "MySQL",
                        "REST API",
                        "Git",
                        "GitHub",
                        "Docker"
                );

            case PYTHON_DEVELOPER:
                return Arrays.asList(
                        "Python",
                        "Django",
                        "Flask",
                        "Pandas",
                        "NumPy",
                        "SQL",
                        "Git",
                        "Docker"
                );

            case FRONTEND_DEVELOPER:
                return Arrays.asList(
                        "HTML",
                        "CSS",
                        "JavaScript",
                        "React",
                        "Angular",
                        "TypeScript",
                        "Bootstrap",
                        "Git"
                );

            case DATA_ANALYST:
                return Arrays.asList(
                        "SQL",
                        "Excel",
                        "Power BI",
                        "Tableau",
                        "Python",
                        "Pandas",
                        "Statistics"
                );

            case DEVOPS_ENGINEER:
                return Arrays.asList(
                        "Docker",
                        "Kubernetes",
                        "AWS",
                        "Linux",
                        "Jenkins",
                        "Git",
                        "Terraform"
                );

            default:
                return Collections.emptyList();
        }
    }
}