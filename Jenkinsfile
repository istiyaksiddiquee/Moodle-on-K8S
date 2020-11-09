def docker_release_tag = "0.9.0"

pipeline{
    agent any
    
    stages{
        stage("Check SCM") {
            steps {
                checkout scm
            }            
        }
        stage("Build MicroServices"){
            parallel {
                stage("Building UserManagement") {
                    steps{
                        echo "=====Building Docker Image for UserManagement====="
                        dir("Project/usermanagement") {
                            script {
                                docker.build("istiyaksiddiquee/usermanagement:${docker_release_tag}")
                            }
                        }
                    }
                }
                stage("Building Noticemanagement") {
                    steps{
                        echo "=====Building Docker Image for Noticemanagement====="
                        dir("Project/noticemanagement") {
                            script {
                                docker.build("istiyaksiddiquee/noticemanagement:${docker_release_tag}")
                            }
                        }
                    }
                }
                stage("Building Alexandria") {
                    steps{
                        echo "=====Building Docker Image for Alexandria====="
                        dir("Project/alexandria") {
                            script {
                                docker.build("istiyaksiddiquee/alexandria:${docker_release_tag}")
                            }
                        }
                    }
                }
                
            }            
        }
        stage("Deployment") {            
            steps {
                echo "=====Deploying helm charts manually====="
                dir("Project/helm-deploy") {                    
                    sh "helm upgrade --install --wait --timeout 360s pgdb -f ./charts/postgresql/values.yaml ./charts/postgresql -n development"
                    sh "helm upgrade --install --wait --timeout 360s mysqldb -f ./charts/mysql/values.yaml ./charts/mysql -n development"
                    sh "helm upgrade --install --wait spring-usermanagement -f ./values/combined_values.yaml ./charts/spring-usermanagement --set app.container.tag='${docker_release_tag}'  -n development"
                    sh "helm upgrade --install --wait go-alexandria -f ./values/combined_values.yaml ./charts/go-alexandria --set go.container.tag='${docker_release_tag}' -n development"
                    sh "helm upgrade --install --wait nest-noticemgmt -f ./values/combined_values.yaml ./charts/nest-noticemgmt --set nest.container.tag='${docker_release_tag}'  -n development"
                }
            }
        }
        // stage("Clean-Up") {
        //     steps {
        //         echo "=====Cleaning up deployments====="
        //         dir("Project/helm-deploy") {                    
        //             sh 'helm uninstall go-alexandria -n development'
        //             sh 'helm uninstall spring-usermanagement -n development'
        //             sh 'helm uninstall nest-noticemgmt -n development'
        //             sh 'helm uninstall mysqldb -n development'
        //             sh 'helm uninstall pgdb -n development'
        //         }
        //     }
        // }
        
    }    
}