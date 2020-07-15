#!groovy

// status = 'Project 1'

pipeline{
    agent{
        label "node"
    }
    stages{
        stage("Project 1"){
            steps{
                echo "========executing script from project 1========"
                load 'Project/Project1/Jenkinsfile'
            }            
        }
    }    
}