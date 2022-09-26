pipeline {
  agent any
  stages {
    stage('Checkout Code') {
      steps {
        git(url: 'https://github.com/ankurkumarz/cloudcost-inspector.git', branch: 'main')
      }
    }

    stage('Build Code') {
      steps {
        sh './gradlew assemble'
      }
    }

    stage('Run Unit Tests') {
      steps {
        sh './gradlew test'
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

    stage('Run Static Security Scan') {
      steps {
        sh 'ls'
      }
    }

    stage('Check Software Supply Chain Security - SCA') {
      steps {
        sh 'ls'
        sh './gradlew dependencies --write-locks '
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