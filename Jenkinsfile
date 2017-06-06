pipeline {
  agent {
    node {
      label 'start'
    }
    
  }
  stages {
    stage('./grailsw compile') {
      steps {
        sh './grailsw compile; ./grails prod war'
      }
    }
  }
}