pipeline {
    agent any
    
    stages {
        stage ('Compile Stage') {

            steps {
                
                    sh 'mvn clean'
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
