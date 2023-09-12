package danekerscode.courseservice.mapper;

import danekerscode.courseservice.dto.FeedbackDTO;
import danekerscode.courseservice.model.Course;
import danekerscode.courseservice.model.Feedback;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Date;

@Mapper
public interface FeedbackMapper {

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "time" , expression = "java(currentDate())")
    Feedback toModel(FeedbackDTO dto, Course course);

    default Date currentDate(){
        return new Date();
    }
}

