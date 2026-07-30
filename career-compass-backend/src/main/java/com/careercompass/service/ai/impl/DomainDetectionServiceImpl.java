package com.careercompass.service.ai.impl;

import com.careercompass.enums.ResumeDomain;
import com.careercompass.service.ai.DomainDetectionService;
import com.careercompass.util.ResumeDomainDetector;
import org.springframework.stereotype.Service;

@Service
public class DomainDetectionServiceImpl
        implements DomainDetectionService {

    @Override
    public ResumeDomain detectDomain(String resumeText) {
        return ResumeDomainDetector.detect(resumeText);
    }
}