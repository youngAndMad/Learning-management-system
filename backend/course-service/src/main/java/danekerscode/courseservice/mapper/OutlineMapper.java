package danekerscode.courseservice.mapper;

import danekerscode.courseservice.dto.OutlineDTO;
import danekerscode.courseservice.model.Course;
import danekerscode.courseservice.model.Outline;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface OutlineMapper {

    @Mapping(target = "id" , ignore = true)
    Outline toModel(OutlineDTO dto, Course course);

    void update(OutlineDTO dto, @MappingTarget Outline outline);
}


