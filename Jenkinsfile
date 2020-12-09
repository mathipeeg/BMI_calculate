pipeline{
	agent any

	tools {
		maven "M3"
	}

	stages {
		stage("Build and Test") {
			steps {
				git 'https://github.com/mathipeeg/BMI_calculate'

				sh "mvn -Dmaven.test.failure.ignore=true clean package"
			}
			post {
				success {
				junit '**/target/surefire-reports/TEST-*.xml'
				archiveArtifacts 'target/*.jar'
				}
			}
		}
        stage('Deploy') {
            if( env.BRANCH_NAME.startsWith("development-") ) {
                echo 'Branch starts with a thing.'
            }
            steps {
                echo 'Deploying'
            }
        }
	}
}
