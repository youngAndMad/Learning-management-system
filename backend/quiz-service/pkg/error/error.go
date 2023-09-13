package errs

import (
	"errors"
	"fmt"
	"net/http"
)

var (
	ErrAnswerNotExists   = errors.New("answer not found")
	ErrQuizNotExists     = errors.New("quiz not found")
	ErrQuestionNotExists = errors.New("question not found")
)

func Fail(err error, place string) error {
	return fmt.Errorf("%s: %s", place, err.Error())
}

func WebFail(status int) error {
	return fmt.Errorf(http.StatusText(status))
}
