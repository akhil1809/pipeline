pipeline {
    agent any
    tools {
        maven 'Maven_3.6.2' 
    }
    stages {
        stage ('Compile Stage') {

            steps {
                
                    sh 'mvn clean compile'
            }
        }
        stage ('Testing Stage') {

            steps {
                
                    sh 'mvn clean test'
            }
        }
        stage ('Install Stage') {
            steps {
              
                    sh 'mvn install'
               
            }
        }
    }
}
