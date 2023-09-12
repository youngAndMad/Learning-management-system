package danekerscode.courseservice.service.impl;

import danekerscode.courseservice.dto.LessonDTO;
import danekerscode.courseservice.exception.EntityNotFoundException;
import danekerscode.courseservice.mapper.LessonMapper;
import danekerscode.courseservice.model.Course;
import danekerscode.courseservice.model.Lesson;
import danekerscode.courseservice.repository.LessonRepository;
import danekerscode.courseservice.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    public void delete(Long id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public Lesson save(LessonDTO dto, Course course) {
        var model = lessonMapper.toModel(dto, course);

        return lessonRepository.save(model);
    }

    @Override
    public void update(Long id, LessonDTO dto) {
        var lesson = this.findById(id);

        lessonMapper.update(dto,lesson);

        lessonRepository.save(lesson);
    }

    @Override
    public Lesson findById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Lesson.class, id));
    }

}
