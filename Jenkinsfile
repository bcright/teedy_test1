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
                sh 'mvn pmd:pmd' --fail-never
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/site/**', fingerprint: true --fail-never
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true --fail-never
            archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true --fail-never
        }
    }
}
