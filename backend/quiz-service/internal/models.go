package internal

import "time"

type Answer struct {
	ID         uint64 `json:"id"`
	Value      string `json:"value"`
	IsCorrect  bool   `json:"is_correct"`
	QuestionID string `json:"question_id"`
}

type Question struct {
	ID             uint64 `json:"id"`
	MaxAttempts    uint64 `json:"max_attempts"`
	CurrentAttempt uint64 `json:"current_attempt"`
	Value          string `json:"value"`
	Answers        []Answer
	QuizID         string `json:"quiz_id"`
}

type Quiz struct {
	ID              uint64 `json:"id"`
	Questions       []Question
	CourseId        string    `json:"course_id"`
	ReviewIsAllowed bool      `json:"review_is_allowed"`
	StartTime       time.Time `json:"start_time"`
	EndTime         time.Time `json:"end_time"`
	DurationMinute  uint64    `json:"duration_minute"`
}
