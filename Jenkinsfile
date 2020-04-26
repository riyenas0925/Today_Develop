pipeline {
  agent any
  stages {
    stage('Source') {
      steps {
        git(url: 'https://github.com/riyenas0925/Today_I_Learned', credentialsId: 'riyenas0925')
      }
    }

    stage('Clean') {
      steps {
        sh '''ls -al
chmod +x mvnw
./mvnw clean'''
      }
    }

  }
}