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
                dir("Project/usermanagement") {
                    script {
                        docker.build("istiyaksiddiquee/usermanagement:0.7.0")
                    }
                }
            }
        }
        
    }    
}