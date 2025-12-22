pipeline {
  agent any

  options {
    timestamps()
    disableConcurrentBuilds()
  }

  environment {
    TEST_IMAGE     = "pw-autotest:latest"
    GRADLE_CACHE   = "gradle_cache"

    ALLURE_ENDPOINT   = "https://autshetalig.testops.cloud"
    ALLURE_PROJECT_ID = "1"
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build test image') {
      steps {
        sh 'docker build -t ${TEST_IMAGE} .'
      }
    }

    stage('Run tests (Docker + xvfb)') {
      steps {
        script {
          // Запускаем тесты; даже если упали — пайплайн продолжит, чтобы сделать upload в TestOps
          def code = sh(
            script: '''
              chmod +x ./gradlew || true
              docker run --rm \
                -v jenkins_home:/var/jenkins_home \
                -v ${GRADLE_CACHE}:/root/.gradle \
                -w "$WORKSPACE" \
                --shm-size=4g \
                ${TEST_IMAGE} \
                /bin/sh -lc "chmod +x ./gradlew || true; xvfb-run -a sh ./gradlew --no-daemon clean test"
            ''',
            returnStatus: true
          )

          if (code != 0) {
            currentBuild.result = 'UNSTABLE'   // тесты упали, но отчёты/выгрузка всё равно делаем
          }
        }
      }
    }

    stage('Upload to Allure TestOps') {
      steps {
        withCredentials([string(credentialsId: 'allure_token', variable: 'ALLURE_TOKEN')]) {
          sh '''
            # ставим allurectl (внутри Jenkins-контейнера)
            if ! command -v allurectl >/dev/null 2>&1; then
              mkdir -p /var/jenkins_home/.bin
              curl -fsSL -o /var/jenkins_home/.bin/allurectl \
                https://github.com/allure-framework/allurectl/releases/latest/download/allurectl_linux_amd64
              chmod +x /var/jenkins_home/.bin/allurectl
            fi

            export PATH="/var/jenkins_home/.bin:$PATH"
            export ALLURE_ENDPOINT="${ALLURE_ENDPOINT}"
            export ALLURE_PROJECT_ID="${ALLURE_PROJECT_ID}"

            # важно: не печатаем токен в лог
            allurectl upload build/allure-results
          '''
        }
      }
    }
  }

  post {
    always {
      // (опционально) если хочешь Allure Report внутри Jenkins по каждому билду:
      // Нужно: установленный "Allure Jenkins Plugin"
      // allure(results: [[path: 'build/allure-results']])

      archiveArtifacts artifacts: 'build/allure-results/**,build/reports/tests/test/**', allowEmptyArchive: true
    }
  }
}
