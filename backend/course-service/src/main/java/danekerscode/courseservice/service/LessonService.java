package danekerscode.courseservice.service;

import danekerscode.courseservice.dto.LessonDTO;
import danekerscode.courseservice.mapper.LessonMapper;
import danekerscode.courseservice.model.Course;
import danekerscode.courseservice.model.Lesson;

public interface LessonService {

    void delete(Long id);

    Lesson save(LessonDTO dto, Course course);

    void update(Long id, LessonDTO dto);

    Lesson findById(Long id);

}
