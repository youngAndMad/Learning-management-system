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

func (ansRepo *AnswerRepository) delete(id int) error {
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
