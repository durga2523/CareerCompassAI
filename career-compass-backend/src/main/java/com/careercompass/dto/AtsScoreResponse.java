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
public class AtsScoreResponse {

    private int score;
    private List<String> strengths;
    private List<String> missingSkills;
    private List<String> suggestions;
}