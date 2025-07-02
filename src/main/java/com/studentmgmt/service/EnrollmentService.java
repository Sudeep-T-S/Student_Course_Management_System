package com.studentmgmt.service;

import com.studentmgmt.dto.EnrollmentDTO;
import java.util.List;

public interface EnrollmentService {
    EnrollmentDTO enrollStudent(Long studentId, Long courseId);
    List<EnrollmentDTO> getAllEnrollments();
}
