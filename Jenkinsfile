pipeline{
    agent {
        docker {
            image 'helmfile_streamlined:latest'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
            args '-v /root/.kube:/root/.kube'            
        }
    }
    
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
            steps {
                echo "=====Deploying UserManagement using Helmfile====="
                dir("Project/helm-deploy") {
                    sh 'helmfile apply'                    
                }
            }
            
        }
        
    }    
}