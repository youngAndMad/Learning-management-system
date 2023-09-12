package danekerscode.courseservice.dto;

public record FeedbackDTO (
        String value,
        Long userId,
        Float point,
        String user
){
}
