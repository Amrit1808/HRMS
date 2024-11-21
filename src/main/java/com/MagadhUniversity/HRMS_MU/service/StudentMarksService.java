package com.MagadhUniversity.HRMS_MU.service;


import com.MagadhUniversity.HRMS_MU.model.StudentMarks;
import java.util.List;

public interface StudentMarksService {
    StudentMarks createStudentMarks(StudentMarks studentMarks);
    List<StudentMarks> getAllStudentMarks();
    StudentMarks getStudentMarksById(Long markId);  // Add this method
    StudentMarks updateStudentMarks(Long markId, StudentMarks studentMarks);
    void deleteStudentMarks(Long markId);
}

