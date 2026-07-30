package com.careercompass.service.ai;

import java.util.List;

public interface SkillExtractionService {

    List<String> extractSkills(String text);
}