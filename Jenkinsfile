pipeline {
    agent any
    stages {
        
        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'apache-maven-3.6.1') {
                    bat 'mvn clean test -Dsuite=recharge'
                }
            }
        }
        
    }
}
