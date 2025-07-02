package com.studentmgmt.service.impl;

import com.studentmgmt.dto.CourseDTO;
import com.studentmgmt.exception.ResourceNotFoundException;
import com.studentmgmt.model.Course;
import com.studentmgmt.repository.CourseRepository;
import com.studentmgmt.service.CourseService;
import com.studentmgmt.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course course = DataMapper.toCourseEntity(courseDTO);
        Course saved = courseRepository.save(course);
        return DataMapper.toCourseDTO(saved);
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        return DataMapper.toCourseDTO(course);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(DataMapper::toCourseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Course not found with id: " + id);
        }
        courseRepository.deleteById(id);
    }
}
