pipeline{
    agent any
    
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
                    sh 'pwd'
                    load 'Jenkinsfile'
                    // sh 'mvn clean install'
                }
            }
        }
        
    }    
}