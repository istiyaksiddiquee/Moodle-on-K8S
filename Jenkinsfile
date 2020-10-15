pipeline{
    agent any
    
    stages{
        stage("Check SCM") {
            steps {
                checkout scm
            }            
        }
        stage("Build Spring-UserManagement"){
            steps{
                echo "=====Building Docker Image for UserManagement====="
                dir("Project/usermanagement") {
                    script {
                        docker.build("istiyaksiddiquee/usermanagement:0.7.0")
                    }
                }
            }
        }
        stage("Deployment") {
            agent {
                docker { image 'quay.io/roboll/helmfile:helm3-v0.131.0' }
            }
            echo "=====Deploying UserManagement using Helmfile====="
            dir("Project/helm-deploy") {
                steps {
                    sh 'helmfile apply'
                }
            }
        }
        
    }    
}