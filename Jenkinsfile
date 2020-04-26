pipeline {
  agent any
  stages {
    stage('Clone repository') {
      steps {
        sh '''git clone https://github.com/riyenas0925/Today_Develop.git
cd Today_Develop'''
        git(url: 'https://github.com/riyenas0925/Today_Develop.git', branch: 'develop', changelog: true, credentialsId: 'riyenas0925')
      }
    }

    stage('Clean') {
      steps {
        sh '''cd Today_Develop
chmod +x mvnw
./mvnw clean install'''
      }
    }

  }
}