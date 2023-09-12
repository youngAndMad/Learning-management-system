package danekerscode.courseservice.service;

import danekerscode.courseservice.dto.CourseDTO;
import danekerscode.courseservice.model.Course;

public interface CourseService {
    Course save(CourseDTO courseDTO);

    void delete(Long id);

    Course findById(Long id);
}
