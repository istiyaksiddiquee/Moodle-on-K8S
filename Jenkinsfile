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
                    def usermgmtImage = docker.build("istiyaksiddiquee/usermanagement", ".") 
                    usermgmtImage.push('0.7.0')
                    usermgmtImage.push('latest')
                }
            }
        }
        
    }    
}