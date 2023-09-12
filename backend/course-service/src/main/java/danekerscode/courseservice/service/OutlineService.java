package danekerscode.courseservice.service;

import danekerscode.courseservice.dto.OutlineDTO;
import danekerscode.courseservice.model.Course;
import danekerscode.courseservice.model.Outline;

public interface OutlineService {

    Outline save(OutlineDTO dto, Course course);

    void delete(Long id);

    void update(Long id, OutlineDTO dto);
}
