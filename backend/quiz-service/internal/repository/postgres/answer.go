package postgres

import (
	"github.com/jmoiron/sqlx"
	errs "github.com/youngAndMad/Learning-management-system/tree/master/backend/quiz-service/pkg/error"
)

type AnswerRepository struct {
	db *sqlx.DB
}

func newAnswerRepository(db *sqlx.DB) *AnswerRepository {
	return &AnswerRepository{
		db: db,
	}
}

func (ansRepo *AnswerRepository) Update(isCorrect bool, value string, answerId int) (int, error) {
	query := `
		UPDATE answers
		SET is_correct = $1, value = $2
		WHERE id = $3
		RETURNING id
	`

	var updatedAnswerID int

	_, err := ansRepo.db.NamedExec(query, map[string]interface{}{
		"is_correct": isCorrect,
		"value":      value,
		"id":         answerId,
	})

	if err != nil {
		return 0, errs.Fail(errs.ErrAnswerNotExists, "update answer")
	}

	return updatedAnswerID, nil
}
func (ansRepo *AnswerRepository) DeleteAnswerByID(id int) error {
	tx, err := withTx(ansRepo.db)
	if err != nil {
		return errs.Fail(err, "Delete workspace")
	}
	defer tx.Rollback()

	query := "DELETE FROM answer where id = $1 RETURNING id"

	if _, err := tx.Exec(query, id); err != nil {
		return errs.Fail(err, "Delete answer")
	}

	return tx.Commit()
}

func (ansRepo *AnswerRepository) Save(isCorrect bool, questionId int, value string) (int, error) {
	tx, err := withTx(ansRepo.db)
	if err != nil {
		return 0, err
	}
	defer tx.Rollback()

	var answerId int

	query := "INSERT INTO answer (is_correct , question_id , value) VALUES ($1,$2,$3);"

	if err := tx.Get(&answerId, query, isCorrect, questionId, value); err != nil {
		return 0, err
	}

	return answerId, tx.Commit()
}
