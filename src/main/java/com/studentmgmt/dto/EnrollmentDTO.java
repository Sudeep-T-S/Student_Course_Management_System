package com.studentmgmt.dto;

import lombok.Data;

@Data
public class EnrollmentDTO {
    private Long enrollmentId;
    private Long id;
    private Long studentId;
    private Long courseId;
    private String studentName;
    private String studentEmail;
    private String courseTitle;
    private String courseDescription;
}
