pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git(url: 'https://github.com/ankurkumarz/cloudcost-inspector.git', branch: 'main')
      }
    }

    stage('Build') {
      steps {
        withGradle() {
          sh 'ls'
        }

      }
    }

  }
}