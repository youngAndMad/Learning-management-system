package danekerscode.courseservice.dto;

import java.util.List;

public record CourseDTO(
        String name,
        String description,
        String header,
        List<LessonDTO> lessons,
        List<OutlineDTO> outlines
) {
}
