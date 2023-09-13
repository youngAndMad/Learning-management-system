package config

import "os"

type DbConfigs struct {
	Name     string
	Password string
	SslMode  string
	Host     string
	Port     string
	DbName   string
}

func NewDbConfigs() *DbConfigs {
	return &DbConfigs{
		Name:     os.Getenv("USER_NAME"),
		DbName:   os.Getenv("DB_NAME"),
		Password: os.Getenv("DB_PASSWORD"),
		SslMode:  os.Getenv("DB_SSL_MODE"),
		Host:     os.Getenv("DB_HOST"),
		Port:     os.Getenv("DB_PORT"),
	}
}
