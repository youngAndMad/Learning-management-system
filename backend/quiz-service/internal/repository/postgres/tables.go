package postgres

import (
	"fmt"
	"github.com/jmoiron/sqlx"
	errs "github.com/youngAndMad/Learning-management-system/tree/master/backend/quiz-service/pkg/error"
	"io/ioutil"
	"os"
)

const (
	QuizTable     = "migrations/000001_create_quiz_table.up.sql"
	QuestionTable = "migrations/000002_create_question_table.up.sql"
	AnswerTable   = "migrations/000003_create_answer_table.up.sql"
)

func createTables(db *sqlx.DB) error {
	if err := createTable(db, "quiz", QuizTable); err != nil {
		fmt.Println("Failed to create quiz table:", err)
		return err
	}

	if err := createTable(db, "question", QuestionTable); err != nil {
		fmt.Println("Failed to create question table:", err)
		return err
	}

	if err := createTable(db, "answer", AnswerTable); err != nil {
		fmt.Println("Failed to create answer table:", err)

		return err
	}

	return nil
}

func createTable(db *sqlx.DB, tableName string, sqlFile string) error {
	f, err := os.OpenFile(sqlFile, os.O_RDONLY, 0o755)
	if err != nil {
		return errs.Fail(err, "Create tables")
	}
	defer f.Close()

	tableSQL, err := ioutil.ReadAll(f)
	if err != nil {
		return err
	}

	tx, err := db.Begin()
	if err != nil {
		return errs.Fail(err, "Begin transaction")
	}

	_, err = tx.Exec(string(tableSQL))
	if err != nil {
		_ = tx.Rollback()
		return errs.Fail(err, "Create table "+tableName)
	}

	if err := tx.Commit(); err != nil {
		return errs.Fail(err, "Commit transaction")
	}

	return nil
}
