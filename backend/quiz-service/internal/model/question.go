package model

type Question struct {
	ID             uint64 `json:"id"`
	MaxAttempts    uint64 `json:"max_attempts"`
	CurrentAttempt uint64 `json:"current_attempt"`
	Value          string `json:"value"`
	Answers        []Answer
	QuizID         string `json:"quiz_id"`
}
