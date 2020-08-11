pipeline {
  agent any

  // add timestamps and colors to console log
  options {
    timestamps()
    ansiColor('xterm')
  }

  stages {
    // build an artifact from source
    stage('Build') {
      steps {
        git url: 'ssh://git@bitbucket.org/crimethinking/weakqueens.git', credentialsId: "${params.CREDENTIAL_ID}"

        sh 'mvn clean package -B -DskipTests -Dbuild.number=${BUILD_NUMBER}'
      }
    }

    // run junit unit tests
    stage('Test') {
      steps {
        sh 'mvn test -B'
      }

      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
      }
    }
    
    // provision the app VM using ansible
    stage('Prepare Environment') {
      steps {
        ansiblePlaybook colorized: true,
        credentialsId: "${params.CREDENTIAL_ID}",
        limit: 'app',
        installation: 'Default',
        playbook: 'provision/playbook.yml', 
        become: true
      }
    }
    
    // clean remote of old builds, distribute the artifact to app VM over SSH and run it
    stage('Deploy') {
      steps {
        sshPublisher(
          continueOnError: false,
          failOnError: true,
          publishers: [
            sshPublisherDesc(
              configName: 'app',
              verbose: true,
              transfers: [
                sshTransfer(
                  sourceFiles: 'target/*.jar',
                  remoteDirectory: 'prod-builds',
                  removePrefix: 'target',
                  cleanRemote: true,
                  execCommand: 'java -jar prod-builds/weakqueens-1.0-${BUILD_NUMBER}.jar'
                )
              ]
            )
          ]
        )
      }
    }
  }
      
  // always archive artifact and clean workspace
  post {
    always {
      archiveArtifacts 'target/*.jar'
      cleanWs()
    }
  }
}
