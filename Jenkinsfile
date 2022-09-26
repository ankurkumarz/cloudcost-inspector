pipeline {
  agent any
  stages {
    stage('Code Checkout') {
      steps {
        git(url: 'https://github.com/ankurkumarz/cloudcost-inspector.git', branch: 'main')
      }
    }

    stage('Code Build') {
      steps {
        sh './gradlew assemble'
      }
    }

    stage('Check Code Quality') {
      environment {
        SONAR_TOKEN = credentials('SONAR_TOKEN')
      }
      steps {
        withSonarQubeEnv('Sonar') {
          sh './gradlew sonarqube -Dsonar.login=${SONAR_TOKEN}'
        }

      }
    }

    stage('Run Unit Tests') {
      steps {
        sh './gradlew test'
      }
    }

    stage('Run Security Scan') {
      steps {
        sh 'ls'
      }
    }

    stage('Run Unit Performance Tests') {
      steps {
        sh 'ls'
      }
    }


   stage('Package as Docker Container') {
      steps {
        sh 'ls'
      }
   }

   stage('Publish to Artifactory') {
      steps {
        sh 'ls'
      }
   }





  }
}