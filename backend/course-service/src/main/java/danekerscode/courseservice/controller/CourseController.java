package danekerscode.courseservice.controller;

import danekerscode.courseservice.dto.CourseDTO;
import danekerscode.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseController {

    private final CourseService courseService;

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(
            @PathVariable Long id
    ) {
        courseService.delete(id);
    }

    @GetMapping("{id}")
    ResponseEntity<?> find(
            @PathVariable Long id
    ) {
        return ResponseEntity
                .ok(courseService.findById(id));
    }

    @PostMapping
    ResponseEntity<?> save(
            @RequestBody CourseDTO courseDTO
    ) {
        return ResponseEntity
                .ok(
                        courseService.save(courseDTO)
                );
    }


}
