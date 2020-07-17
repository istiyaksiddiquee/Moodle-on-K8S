pipeline{
    agent any
    
    stages{
        stage("Check SCM") {
            steps {
                checkout scm
            }            
        }
        stage("Project1"){
            load 'Project/Project1/Jenkinsfile'
            steps{
                echo "========executing A========"
                // dir("Project/Project1") {
                //     sh 'pwd'
                //     sh 'mvn clean install'
                // }
            }
        }
        
    }    
}