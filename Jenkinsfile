pipeline{
    agent any
     tools { 
        maven 'Maven 3' 
    }
    stages{
        stage("Check SCM") {
            steps {
                checkout scm
            }            
        }
        stage("Project1"){
            steps{
                echo "========executing A========"
                dir("Project/Project1") {
                    sh 'ls'
                    sh 'mvn clean compile package -s settings.xml'
                }
            }
        }
    }    
}