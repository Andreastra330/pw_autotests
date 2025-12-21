pipeline {
    agent any  // Основной агент Jenkins (твой текущий контейнер)

    stages {
        stage('Checkout') {
            steps {
                checkout scm  // Автоматически клонирует репозиторий
            }
        }

        stage('Install Playwright Browsers') {
            // Опционально: если браузеры не предустановлены в образе (но в v1.56.0-noble они есть)
            agent {
                docker {
                    image 'mcr.microsoft.com/playwright/java:v1.56.0-noble'  // Твоя версия Playwright
                    reuseNode true  // Использует тот же workspace
                }
            }
            steps {
                sh 'mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install --with-deps" || true'
            }
        }

        stage('Run Tests') {
            agent {
                docker {
                    image 'mcr.microsoft.com/playwright/java:v1.56.0-noble'
                    reuseNode true
                    args '--shm-size=2g'  // Важно для Playwright (память для браузеров)
                }
            }
            steps {
                sh './gradlew clean test'  // Твоя команда (или просто 'gradle clean test')
            }
        }
    }

    post {
        always {
            // Генерация и архивация Allure-отчёта (как у тебя уже настроено)
            script {
                sh '/var/jenkins_home/tools/ru.yandex.qatools.allure.jenkins.tools.AllureCommandlineInstallation/AllureJenkins/bin/allure generate build/allure-results -c -o build/allure-report || true'
            }
            archiveArtifacts artifacts: 'build/allure-report/**', allowEmptyArchive: true
            // Если используешь Allure plugin в Jenkins — добавь шаг allure
            allure results: [[path: 'build/allure-results']]
        }
    }
}