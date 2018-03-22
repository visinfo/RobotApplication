pipeline {
  agent {
    node {
      label 'checkout'
    }
    
  }
  stages {
    stage('checkout') {
      steps {
        bat(script: '      checkout scm', returnStdout: true)
      }
    }
  }
}