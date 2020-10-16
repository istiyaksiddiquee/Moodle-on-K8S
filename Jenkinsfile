pipeline{
    agent {
        docker {
            image 'helmfile_streamlined:latest'
            args '-v /root/.kube:/root/.kube -v /var/run/docker.sock:/var/run/docker.sock' 
        }
    }
    
    stages{
        stage("Check SCM") {
            steps {
                checkout scm
            }            
        }
        // stage("Build Spring-UserManagement"){
        //     steps{
        //         echo "=====Building Docker Image for UserManagement====="
        //         dir("Project/usermanagement") {
        //             script {
        //                 docker.build("istiyaksiddiquee/usermanagement:0.7.0")
        //             }
        //         }
        //     }
        // }
        stage("Deployment") {            
            steps {
                echo "=====Deploying UserManagement using Helmfile====="
                dir("Project/helm-deploy") {
                    sh 'kubectl config view --raw >~/.kube/config'
                    sh 'export KUBECONFIG=/root/.kube'
                    sh 'helmfile apply'
                }
            }
            
        }
        
    }    
}