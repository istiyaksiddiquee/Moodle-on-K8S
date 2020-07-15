#!groovy

// status = 'Project 1'

node {
    stage('Shared') {
        echo 'Shared stage'

        checkout scm
    }
    
    load 'Project/Project1/Jenkinsfile'
    // load 'Project/Project2/Jenkinsfile'
    
}

