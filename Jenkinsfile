node("ci-node") {

    stage("Checkout") {
        checkout scmGit(branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mchekini-check-consulting/pro-epargne-api.git']])
    }

    stage("Unit Tests") {
        sh "chmod 700 mvnw && ./mvnw test"
    }

    stage("Build") {
        sh "./mvnw package -DskipTests"
    }

    stage("Build Docker Image") {
        sh "sudo docker build -t asset-api ."
    }

    stage("Push Docker Image To Registry") {
        sh "sudo docker tag asset-api mchekini/asset-api:1.0"
        withCredentials([usernamePassword(credentialsId: 'mchekini', passwordVariable: 'password', usernameVariable: 'username')]) {
            sh "sudo docker login -u $username -p $password"
            sh "sudo docker push mchekini/asset-api:1.0"
            sh "sudo docker rmi mchekini/asset-api:1.0"
            sh "sudo docker rmi asset-api"
            stash include: 'docker-compose.yml', name: 'utils'
        }
    }

    node("deploy-node") {
        stage("deploy") {
            unstash 'utils'
            try {
                sh "sudo docker-compose down"
                sh "sudo docker-compose pull"
                sh "sudo docker-compose up -d"
            } catch (Exception e) {
                println "No Docker Conatainers Running"
                sh "sudo docker-compose pull"
                sh "sudo docker-compose up -d"
            }
        }
    }
}