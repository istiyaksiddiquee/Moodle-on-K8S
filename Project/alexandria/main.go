package main

import (
	"fmt"
	"log"
	"os"
	TaskController "alexandria/controllers"
	"alexandria/db"

	"github.com/gin-gonic/gin"
)

func main() {

	log.Println("Starting server..")

	db.Init()

	r := gin.Default()

	v1 := r.Group("/api/v1")
	{
		tasks := v1.Group("/tasks")
		{
			tasks.GET("/", TaskController.GetTasks)
			tasks.POST("/", TaskController.CreateTask)
			tasks.PUT("/:id", TaskController.UpdateTask)
			tasks.DELETE("/:id", TaskController.DeleteTask)
		}
	}

	server_port := getEnv("SERVER_PORT", "3000")
	port := fmt.Sprintf(":%s", server_port)
	r.Run(port)
}

func getEnv(key, fallback string) string {
	if value, ok := os.LookupEnv(key); ok {
		return value
	}
	return fallback
}
