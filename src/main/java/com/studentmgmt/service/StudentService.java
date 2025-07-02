package com.studentmgmt.service;

import com.studentmgmt.dto.StudentDTO;
import java.util.List;

public interface StudentService {
    StudentDTO addStudent(StudentDTO studentDTO);
    StudentDTO getStudentById(Long id);
    List<StudentDTO> getAllStudents();
    void deleteStudent(Long id);
}
