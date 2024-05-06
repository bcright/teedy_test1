pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('pmd') {
            steps {
                sh 'mvn pmd:pmd --fail-never' 
            }
        }
        stage('test') {
            steps {
                sh 'mvn test -Dtest=TestCss test --fail-never'
            }
        }
        stage('doc') {
            steps {
                sh 'mvn javadoc:jar --fail-never'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/site/**', fingerprint: true 
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true 
            archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true 
        }
    }
}
