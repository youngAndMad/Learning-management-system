package repository

type Repository struct {
	Answer
}

type Answer interface {
	DeleteAnswerByID(id int) error
	Save(isCorrect bool, questionId int, value string) (int, error)
	Update(isCorrect bool, value string, answerId int) (int error)
}
