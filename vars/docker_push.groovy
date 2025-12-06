def call(String image_name, String image_tag, String DockerHubUserparam) {
    echo "pushing image to Docker Hub"
    withCredentials([usernamePassword(credentialsId: "dockerhub",
                                      usernameVariable: "DockerHubUser",
                                      passwordVariable: "DockerHubPass")]) {
        sh """
        echo "USER=$DockerHubUser"
        echo "PASS length=\${#DockerHubPass}"
        echo $DockerHubPass | docker login -u $DockerHubUser --password-stdin
        docker push $DockerHubUser/${image_name}:${image_tag}
        """
    }
}
