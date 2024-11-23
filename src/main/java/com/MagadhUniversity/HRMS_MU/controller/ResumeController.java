package com.MagadhUniversity.HRMS_MU.controller;

import com.MagadhUniversity.HRMS_MU.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

@Controller // Use @Controller for serving HTML pages
@RequestMapping("/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    // Endpoint to show the resume upload page
    @GetMapping
    public String showUploadPage() {
        // Ensure resume.html exists in src/main/resources/templates
        return "resume";
    }

    // Endpoint to handle resume upload
    @PostMapping("/upload")
    public ResponseEntity<String> uploadResume(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("jobRole") String jobRole,
            @RequestParam("resume") MultipartFile resume) {
        try {
            // Call the service to save the resume
            resumeService.saveResume(name, email, jobRole, resume);
            return ResponseEntity.ok("Resume uploaded successfully!");
        } catch (Exception e) {
            // Handle errors during the upload process
            return ResponseEntity.status(500).body("Error uploading resume: " + e.getMessage());
        }
    }
}
