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

    stage('Run Unit Test') {
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
        sh './gradlew dependencies --write-locks '
        snykSecurity(
          snykInstallation: 'SNYK',
          snykTokenId:'SNYK_API_TOKEN',
          failOnIssues: 'false'
        )
        //sh 'phylum analyze gradle.lockfile'
      }
    }

    stage('Run Unit Performance Test') {
      steps {
        sh 'ls'
      }
    }

    stage('Run Integration Test') {
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