pipeline {
  agent any
  stages {
    stage('Clone repository') {
      steps {
        sh '''git clone https://github.com/riyenas0925/Today_Develop.git
cd Today_Develop'''
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