#!groovy

// status = 'Project 1'

node {
    stage('Shared') {
        echo 'Shared stage'

        checkout scm
    }

    // load 'Project1/Jenkinsfile'
    load 'Project2/Jenkinsfile'
    
}

