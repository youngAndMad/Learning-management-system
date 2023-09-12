package danekerscode.courseservice.dto;

import java.math.BigDecimal;
import java.util.List;

public record CourseDTO(
        String name,
        String description,
        String header,
        List<LessonDTO> lessons,
        List<OutlineDTO> outlines,
        BigDecimal price
) {
}
