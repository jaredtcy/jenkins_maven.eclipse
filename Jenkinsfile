pipeline{
	agent any
	tools{
		maven 'maven 3.9.9'
		jdk 'Java JDK 17'
	}
	stages{
		stage('clean'){
			steps {
				
				echo 'Start Clean'
				sh 'mvn clean'
				
			}
			
			
		}
		stage('test') {
			steps {
				echo 'Start Test'
				sh 'mvn test'
				
				
			}
			
			
		}
		stage('build'){
			steps{
				echo 'Start build'
				sh 'mvn install -DskipTests'
				
				
			}
			
			
			
		}
		
	}
	
	
	
}