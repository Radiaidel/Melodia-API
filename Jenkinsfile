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
                bat  'mvn clean install -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                bat 'docker build -t ${DOCKER_IMAGE} .'
            }
        }
    }
    post {
        always {
            echo 'Pipeline finished.'
        }
    }
}
