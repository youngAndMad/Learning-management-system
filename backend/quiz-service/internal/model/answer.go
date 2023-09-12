package model

type Answer struct {
	ID         uint64 `json:"id"`
	Value      string `json:"value"`
	IsCorrect  bool   `json:"is_correct"`
	QuestionID string `json:"question_id"`
}
