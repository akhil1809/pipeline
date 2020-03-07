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
                
                    sh 'mvn clean test -Dsuite=recharge'
            }
        }
        stage ('Install Stage') {
            steps {
              
                    sh 'mvn install'
               
            }
        }
    }
    post {
        always {
            sh 'allure serve allure-results'
        }
    }
}
