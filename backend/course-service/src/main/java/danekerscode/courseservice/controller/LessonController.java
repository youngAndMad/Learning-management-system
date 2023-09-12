package danekerscode.courseservice.controller;

import danekerscode.courseservice.dto.LessonDTO;
import danekerscode.courseservice.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(
            @PathVariable Long id
    ) {
        lessonService.delete(id);
    }

    @PatchMapping("{id}")
    void update(
            @PathVariable Long id,
            @RequestBody LessonDTO lessonDTO
    ) {
        lessonService.update(id, lessonDTO);
    }

    @GetMapping("{id}")
    ResponseEntity<?> find(
            @PathVariable Long id
    ) {
        return ResponseEntity
                .ok(lessonService.findById(id));
    }
}
