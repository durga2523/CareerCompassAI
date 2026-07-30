package com.careercompass.util;

import com.careercompass.enums.ResumeDomain;

public class ResumeDomainDetector {

    public static ResumeDomain detect(String resumeText) {

        String text = resumeText.toLowerCase();

        if (text.contains("spring boot") || text.contains("hibernate")) {
            return ResumeDomain.JAVA_DEVELOPER;
        }

        if (text.contains("django") || text.contains("flask")) {
            return ResumeDomain.PYTHON_DEVELOPER;
        }

        if (text.contains("angular") || text.contains("react")) {
            return ResumeDomain.FRONTEND_DEVELOPER;
        }

        if (text.contains("power bi") || text.contains("tableau")) {
            return ResumeDomain.DATA_ANALYST;
        }

        if (text.contains("docker") && text.contains("kubernetes")) {
            return ResumeDomain.DEVOPS_ENGINEER;
        }

        return ResumeDomain.UNKNOWN;
    }
}