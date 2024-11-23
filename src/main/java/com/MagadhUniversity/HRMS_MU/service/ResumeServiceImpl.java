package com.MagadhUniversity.HRMS_MU.service;

import com.MagadhUniversity.HRMS_MU.model.ResumeEntity;
import com.MagadhUniversity.HRMS_MU.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public ResumeServiceImpl(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @Override
    public void saveResume(String name, String email, String jobRole, MultipartFile resume) throws IOException {
        String filePath = uploadDir + "/" + resume.getOriginalFilename();
        File file = new File(filePath);
        resume.transferTo(file);

        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setName(name);
        resumeEntity.setEmail(email);
        resumeEntity.setJobRole(jobRole);
        resumeEntity.setFilePath(filePath);

        resumeRepository.save(resumeEntity);
    }
}
