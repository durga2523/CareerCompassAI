package com.careercompass.service.ai;

import com.careercompass.dto.AtsScoreResponse;
import com.careercompass.enums.ResumeDomain;

import java.util.List;

public interface AtsScoringService {

    AtsScoreResponse calculateScore(
            ResumeDomain domain,
            List<String> skills);
}