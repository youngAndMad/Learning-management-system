package danekerscode.courseservice.service.impl;

import danekerscode.courseservice.dto.OutlineDTO;
import danekerscode.courseservice.exception.EntityNotFoundException;
import danekerscode.courseservice.mapper.OutlineMapper;
import danekerscode.courseservice.model.Course;
import danekerscode.courseservice.model.Outline;
import danekerscode.courseservice.repository.OutlineRepository;
import danekerscode.courseservice.service.OutlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OutlineServiceImpl implements OutlineService {

    private final OutlineRepository outlineRepository;
    private final OutlineMapper outlineMapper;

    @Override
    public Outline save(OutlineDTO dto, Course course) {
        var model = outlineMapper.toModel(dto,course);
        return outlineRepository.save(model);
    }

    @Override
    public void delete(Long id) {
        outlineRepository.deleteById(id);
    }

    @Override
    public void update(Long id, OutlineDTO dto) {
        var outline =this.findById(id);

        outlineMapper.update(dto,outline);

        outlineRepository.save(outline);
    }

    private Outline findById(Long id){
        return outlineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Outline.class, id));
    }
}
