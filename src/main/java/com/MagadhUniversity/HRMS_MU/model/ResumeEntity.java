package com.MagadhUniversity.HRMS_MU.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resumes") // Optional: Specifies the table name explicitly
public class ResumeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Name of the applicant
    private String email; // Email address of the applicant
    private String jobRole; // Job role the resume is for
    private String filePath; // Path where the resume file is stored

    // Constructors (Optional, for convenience)
    public ResumeEntity() {}

    public ResumeEntity(String name, String email, String jobRole, String filePath) {
        this.name = name;
        this.email = email;
        this.jobRole = jobRole;
        this.filePath = filePath;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // toString (Optional, for debugging)
    @Override
    public String toString() {
        return "ResumeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobRole='" + jobRole + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
