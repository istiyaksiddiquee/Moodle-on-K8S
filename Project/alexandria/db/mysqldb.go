package db

import (
	"fmt"
	"log"
	"os"
	"alexandria/models"

	_ "github.com/go-sql-driver/mysql"
	"github.com/jinzhu/gorm"
)

var db *gorm.DB
var err error

func getEnv(key, fallback string) string {
	if value, ok := os.LookupEnv(key); ok {
		return value
	}
	return fallback
}

func Init() {

	user := getEnv("PG_USER", "magnumopus")
	password := getEnv("PG_PASSWORD", "123456")
	host := getEnv("PG_HOST", "localhost")
	port := getEnv("PG_PORT", "3306")
	database := getEnv("PG_DB", "exam")

	log.Println(fmt.Sprintf("server address: %s, port: %s", host, port))

	dbinfo := fmt.Sprintf("%s:%s@tcp(%s:%s)/%s?charset=utf8mb4&parseTime=True&loc=Local",
		user,
		password,
		host,
		port,
		database,
	)

	// dsn := "magnumopus:123456@tcp(127.0.0.1:3306)/exam?charset=utf8mb4&parseTime=True&loc=Local"
	db, err = gorm.Open("mysql", dbinfo)

	if err != nil {
		log.Println("Failed to connect to database")
		panic(err)
	}
	log.Println("Database connected")

	db.AutoMigrate(&models.Task{})
}

//GetDB ...
func GetDB() *gorm.DB {
	return db
}
