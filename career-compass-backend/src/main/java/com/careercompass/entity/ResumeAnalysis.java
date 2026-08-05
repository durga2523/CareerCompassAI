package com.careercompass.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "resume_analysis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer atsScore;

    @Column(columnDefinition = "LONGTEXT")
    private String resumeSummary;

    @Column(columnDefinition = "LONGTEXT")
    private String detectedSkills;

    @Column(columnDefinition = "LONGTEXT")
    private String missingSkills;

    @Column(columnDefinition = "LONGTEXT")
    private String recommendations;

    @OneToOne
    @JoinColumn(
            name = "resume_id",
            unique = true
    )
    private Resume resume;
}