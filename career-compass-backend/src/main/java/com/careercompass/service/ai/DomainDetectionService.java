package com.careercompass.service.ai;

import com.careercompass.enums.ResumeDomain;

public interface DomainDetectionService {

    ResumeDomain detectDomain(String resumeText);
}