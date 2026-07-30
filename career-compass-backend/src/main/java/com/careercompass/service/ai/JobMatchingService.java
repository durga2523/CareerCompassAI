package com.careercompass.service.ai;

import com.careercompass.dto.JobMatchResponse;

import java.util.List;

public interface JobMatchingService {

    JobMatchResponse compareSkills(
            List<String> resumeSkills,
            List<String> jobSkills);
}