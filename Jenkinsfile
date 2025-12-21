pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests') {
            agent {
                docker {
                    image 'mcr.microsoft.com/playwright/java:v1.56.0-noble'
                    reuseNode true
                    args '--shm-size=2g'  // Обязательно для стабильности браузеров
                }
            }
            steps {
                sh 'chmod +x gradlew'  // Фикс Permission denied
                sh './gradlew clean test'
            }
        }
    }

    post {
        always {
            // Allure-отчёт (пути по умолчанию для Allure Gradle плагина: build/allure-results)
            allure includeProperties: false, report: 'build/allure-report', results: [[path: 'build/allure-results']]

            // Опционально: архивация артефактов
            archiveArtifacts artifacts: 'build/allure-report/**', allowEmptyArchive: true
        }
        failure {
            echo 'Build failed!'
        }
        success {
            echo 'Tests passed!'
        }
    }
}