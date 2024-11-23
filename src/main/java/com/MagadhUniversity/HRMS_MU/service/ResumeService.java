package com.MagadhUniversity.HRMS_MU.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ResumeService {
    void saveResume(String name, String email, String jobRole, MultipartFile resume) throws IOException;
}
