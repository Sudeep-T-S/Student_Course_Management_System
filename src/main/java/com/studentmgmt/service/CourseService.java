package com.studentmgmt.service;

import com.studentmgmt.dto.CourseDTO;
import java.util.List;

public interface CourseService {
    CourseDTO addCourse(CourseDTO courseDTO);
    CourseDTO getCourseById(Long id);
    List<CourseDTO> getAllCourses();
    void deleteCourse(Long id);
}
