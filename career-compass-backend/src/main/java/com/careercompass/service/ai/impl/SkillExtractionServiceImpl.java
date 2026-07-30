package com.careercompass.service.ai.impl;

import com.careercompass.service.ai.SkillExtractionService;
import com.careercompass.util.SkillExtractorUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillExtractionServiceImpl implements SkillExtractionService {

    @Override
    public List<String> extractSkills(String text) {
        return SkillExtractorUtil.extractSkills(text);
    }
}