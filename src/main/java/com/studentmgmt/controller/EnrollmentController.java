package com.studentmgmt.controller;

import com.studentmgmt.dto.EnrollmentDTO;
import com.studentmgmt.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // Enroll a student to a course
    @PostMapping
    public ResponseEntity<EnrollmentDTO> enrollStudent(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {

        EnrollmentDTO enrollment = enrollmentService.enrollStudent(studentId, courseId);
        return ResponseEntity.ok(enrollment);
    }

    // Get all enrollments
    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }
}
