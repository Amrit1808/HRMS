package com.MagadhUniversity.HRMS_MU.repository;

import com.MagadhUniversity.HRMS_MU.model.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<ResumeEntity, Long> {
    // JpaRepository provides save(), findById(), etc.
}
