package com.careercompass.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "resumes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String fileType;

    private String filePath;

    @Column(columnDefinition = "LONGTEXT")
    private String resumeText;

    private LocalDateTime uploadedAt;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}