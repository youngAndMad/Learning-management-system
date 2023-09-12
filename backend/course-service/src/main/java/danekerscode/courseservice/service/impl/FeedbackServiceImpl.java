package danekerscode.courseservice.service.impl;

import danekerscode.courseservice.dto.FeedbackDTO;
import danekerscode.courseservice.exception.EntityNotFoundException;
import danekerscode.courseservice.mapper.FeedbackMapper;
import danekerscode.courseservice.model.Course;
import danekerscode.courseservice.model.Feedback;
import danekerscode.courseservice.repository.FeedbackRepository;
import danekerscode.courseservice.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;

    @Override
    public void delete(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public Feedback save(Course course, FeedbackDTO feedbackDTO) {
        var model = feedbackMapper.toModel(feedbackDTO, course);

        return feedbackRepository.save(model);
    }

    @Override
    public List<Feedback> findUserFeedbacks(Long userId) {
        return feedbackRepository.findAllByUserId(userId);
    }

    @Override
    public void deleteUserFeedbacks(Long userId) {
        feedbackRepository.deleteAllByUserId(userId);
    }

    @Override
    public Feedback find(Long id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Feedback.class , id));
    }

}
