package com.careercompass.service.ai.impl;

import com.careercompass.dto.JobMatchResponse;
import com.careercompass.service.ai.JobMatchingService;
import com.careercompass.util.JobMatcherUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobMatchingServiceImpl implements JobMatchingService {

    @Override
    public JobMatchResponse compareSkills(
            List<String> resumeSkills,
            List<String> jobSkills) {

        return JobMatcherUtil.compareSkills(
                resumeSkills,
                jobSkills
        );
    }
}