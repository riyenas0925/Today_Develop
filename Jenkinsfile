pipeline {
  agent any
  stages {
    stage('Clone repository') {
      steps {
        git(url: 'https://github.com/riyenas0925/Today_Develop.git', branch: 'develop', changelog: true, credentialsId: 'riyenas0925')
      }
    }

    stage('Clean') {
      steps {
        sh '''chmod +x mvnw
./mvnw clean'''
      }
    }

    stage('Build') {
      steps {
        sh '''chmod +x mvnw
./mvnw install'''
      }
    }

  }
}