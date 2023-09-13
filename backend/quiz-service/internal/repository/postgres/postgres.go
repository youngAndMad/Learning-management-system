package postgres

import (
	"fmt"
	_ "github.com/jackc/pgx/v5/stdlib"
	"github.com/jmoiron/sqlx"
	"github.com/youngAndMad/Learning-management-system/tree/master/backend/quiz-service/config"
	errs "github.com/youngAndMad/Learning-management-system/tree/master/backend/quiz-service/pkg/error"
)

func withTx(db *sqlx.DB) (*sqlx.Tx, error) {
	return db.Beginx()
}

func InitDb(dbCfg *config.DbConfigs) (*sqlx.DB, error) {

	psqlInfo := fmt.Sprintf("host=%s port=%s user=%s "+
		"password=%s dbname=%s sslmode=disable",
		dbCfg.Host, dbCfg.Port, dbCfg.Name, dbCfg.Password, dbCfg.DbName)
	fmt.Println(psqlInfo)
	db, err := sqlx.Open("pgx", psqlInfo)
	if err != nil {
		return nil, err
	}
	if err := db.Ping(); err != nil {
		return nil, err
	}
	if err := createTables(db); err != nil {
		return nil, errs.Fail(err, "Init db")
	}
	return db, nil
}
