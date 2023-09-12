package danekerscode.courseservice.mapper;

import danekerscode.courseservice.dto.FeedbackDTO;
import danekerscode.courseservice.model.Course;
import danekerscode.courseservice.model.Feedback;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface FeedbackMapper {

    @Mapping(target = "id" , ignore = true)
    Feedback toModel(FeedbackDTO dto, Course course);
}
