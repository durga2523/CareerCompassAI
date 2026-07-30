package com.careercompass.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AIResumeAnalysisResponse {

    private Integer atsScore;

    private String resumeSummary;

    private List<String> detectedSkills;

    private List<String> missingSkills;

    private List<String> recommendations;
}
