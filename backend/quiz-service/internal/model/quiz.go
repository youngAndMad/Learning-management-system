package model

import "time"

type Quiz struct {
	ID              uint64 `json:"id"`
	Questions       []Question
	CourseId        string    `json:"course_id"`
	ReviewIsAllowed bool      `json:"review_is_allowed"`
	StartTime       time.Time `json:"start_time"`
	EndTime         time.Time `json:"end_time"`
	DurationMinute  uint64    `json:"duration_minute"`
}
