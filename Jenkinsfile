pipeline{
    agent any
    
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
                    sh 'helm upgrade --install --wait pgdb -f ./charts/postgresql/values.yaml ./charts/postgresql -n development'
                    sh 'helm upgrade --install --wait mysqldb -f ./charts/mysql/values.yaml ./charts/mysql -n development'
                    sh 'helm upgrade --install --wait spring-usermanagement -f ./values/combined_values.yaml ./charts/spring-usermanagement -n development'
                    sh 'helm upgrade --install --wait go-alexandria -f ./values/combined_values.yaml ./charts/go-alexandria -n development'
                    sh 'helm upgrade --install --wait nest-noticemgmt -f ./values/combined_values.yaml ./charts/nest-noticemgmt -n development'
                }
            }
            
        }
        
    }    
}