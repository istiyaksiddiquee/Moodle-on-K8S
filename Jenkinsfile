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
                load 'Project/Project1/Jenkinsfile'
                // dir("Project/Project1") {
                //     sh 'pwd'
                //     sh 'mvn clean install'
                // }
            }
        }
        
    }    
}