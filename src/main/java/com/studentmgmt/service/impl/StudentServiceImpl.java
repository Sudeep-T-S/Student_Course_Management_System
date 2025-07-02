package com.studentmgmt.service.impl;

import com.studentmgmt.dto.StudentDTO;
import com.studentmgmt.exception.ResourceNotFoundException;
import com.studentmgmt.model.Student;
import com.studentmgmt.repository.StudentRepository;
import com.studentmgmt.service.StudentService;
import com.studentmgmt.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = DataMapper.toStudentEntity(studentDTO);
        Student saved = studentRepository.save(student);
        return DataMapper.toStudentDTO(saved);
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return DataMapper.toStudentDTO(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(DataMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}
