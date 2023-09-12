package danekerscode.courseservice.service.impl;

import danekerscode.courseservice.dto.CourseDTO;
import danekerscode.courseservice.exception.EntityNotFoundException;
import danekerscode.courseservice.mapper.CourseMapper;
import danekerscode.courseservice.model.Course;
import danekerscode.courseservice.repository.CourseRepository;
import danekerscode.courseservice.service.CourseService;
import danekerscode.courseservice.service.LessonService;
import danekerscode.courseservice.service.OutlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final LessonService lessonService;
    private final OutlineService outlineService;
    private final CourseMapper courseMapper;

    @Override
    public Course save(CourseDTO courseDTO) {
        var course = courseRepository.save(courseMapper.toModel(courseDTO));

        var lessons = courseDTO.lessons().stream()
                .map(l -> lessonService.save(l, course))
                .toList();

        var outlines = courseDTO.outlines().stream()
                .map(o -> outlineService.save(o, course))
                .toList();

        course.setLessons(lessons);
        course.setOutlines(outlines);

        return courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Course.class, id));
    }
}
