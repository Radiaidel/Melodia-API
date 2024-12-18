pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'project-music-api'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Radiaidel/Melodia-API'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t ${DOCKER_IMAGE} .'
            }
        }
    }
    post {
        always {
            echo 'Pipeline finished.'
        }
    }
}
