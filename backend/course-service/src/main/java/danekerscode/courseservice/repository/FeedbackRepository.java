package danekerscode.courseservice.repository;

import danekerscode.courseservice.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    void deleteAllByUserId(Long userId);

    List<Feedback> findAllByUserId(Long userId);

}
