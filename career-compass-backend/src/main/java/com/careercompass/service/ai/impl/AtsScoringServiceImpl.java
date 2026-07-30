package com.careercompass.service.ai.impl;

import com.careercompass.dto.AtsScoreResponse;
import com.careercompass.enums.ResumeDomain;
import com.careercompass.service.ai.AtsScoringService;
import com.careercompass.util.AtsScoreUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtsScoringServiceImpl implements AtsScoringService {

    @Override
    public AtsScoreResponse calculateScore(
            ResumeDomain domain,
            List<String> skills) {

        return AtsScoreUtil.calculateScore(domain, skills);
    }
}