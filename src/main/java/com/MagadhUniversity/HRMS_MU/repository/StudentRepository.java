package com.MagadhUniversity.HRMS_MU.repository;

import com.MagadhUniversity.HRMS_MU.model.Student;
import com.MagadhUniversity.HRMS_MU.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByDepartment(String department, Pageable pageable);
}
