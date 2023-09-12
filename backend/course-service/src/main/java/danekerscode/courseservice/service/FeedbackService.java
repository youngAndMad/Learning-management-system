package danekerscode.courseservice.service;

import danekerscode.courseservice.dto.FeedbackDTO;
import danekerscode.courseservice.model.Course;
import danekerscode.courseservice.model.Feedback;

import java.util.List;

public interface FeedbackService {
    void delete(Long id);

    Feedback save(Course course, FeedbackDTO feedbackDTO);

    List<Feedback> findUserFeedbacks(Long userId);

    void deleteUserFeedbacks(Long userId);

    Feedback find(Long id);
}
