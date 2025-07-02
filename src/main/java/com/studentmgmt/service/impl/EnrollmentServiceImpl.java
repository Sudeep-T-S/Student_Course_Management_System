package com.studentmgmt.service.impl;

import com.studentmgmt.dto.EnrollmentDTO;
import com.studentmgmt.exception.ResourceNotFoundException;
import com.studentmgmt.model.Course;
import com.studentmgmt.model.Enrollment;
import com.studentmgmt.model.Student;
import com.studentmgmt.repository.CourseRepository;
import com.studentmgmt.repository.EnrollmentRepository;
import com.studentmgmt.repository.StudentRepository;
import com.studentmgmt.service.EnrollmentService;
import com.studentmgmt.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public EnrollmentDTO enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + courseId));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        Enrollment saved = enrollmentRepository.save(enrollment);
        return DataMapper.toEnrollmentDTO(saved);
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        return enrollmentRepository.findAll()
                .stream()
                .map(DataMapper::toEnrollmentDTO)
                .collect(Collectors.toList());
    }
}
