package danekerscode.courseservice.mapper;

import danekerscode.courseservice.dto.LessonDTO;
import danekerscode.courseservice.model.Course;
import danekerscode.courseservice.model.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface LessonMapper {

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "name" , source = "dto.name")
    Lesson toModel(LessonDTO dto, Course course);

    void update(LessonDTO dto, @MappingTarget Lesson lesson);

}

