#!/usr/bin/env groovy

def call(){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-login', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t laweee/demo-java-maven-app:1.3 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push laweee/demo-java-maven-app:1.3'
    }
}
