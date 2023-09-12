package danekerscode.courseservice.controller;

import danekerscode.courseservice.dto.FeedbackDTO;
import danekerscode.courseservice.service.CourseService;
import danekerscode.courseservice.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final CourseService courseService;

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(
            @PathVariable Long id
    ) {
        feedbackService.delete(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUserFeedbacks(
            @RequestParam("user_id") Long userId
    ) {
        feedbackService.deleteUserFeedbacks(userId);
    }

    @GetMapping
    ResponseEntity<?> findUserFeedbacks(
            @RequestParam("user_id") Long userId
    ) {
        return ResponseEntity
                .ok(feedbackService.findUserFeedbacks(userId));
    }

    @GetMapping("{id}")
    ResponseEntity<?> find(
            @PathVariable Long id
    ) {
        return ResponseEntity
                .ok(feedbackService.find(id));
    }

    @PostMapping
    ResponseEntity<?> doFeedback(
            @RequestParam("course_id") Long courseId,
            @RequestBody FeedbackDTO feedbackDTO
    ) {
        return ResponseEntity
                .ok(feedbackService.save(
                        courseService.findById(courseId),
                        feedbackDTO)
                );
    }

}
