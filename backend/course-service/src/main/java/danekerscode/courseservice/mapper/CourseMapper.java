package danekerscode.courseservice.mapper;

import danekerscode.courseservice.dto.CourseDTO;
import danekerscode.courseservice.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface CourseMapper {

    @Mapping(target = "id", ignore = true)
    Course toModel(CourseDTO dto);

}
