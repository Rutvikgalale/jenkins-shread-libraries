def call(String image_name,String image_tag, String DockerHubUserparam){
  echo "pushing image to docker Hub"
  withCredentials([usernamePassword(credentialsId: "DockerHubcred", passwordVariable: "DockerHubPass", usernameVariable: "DockerHubUser")]) {
    sh """
    echo "USER=$DockerHubUser"
    echo "PASS length=\${#DockerHubPass}"
    docker login -u $DockerHubUser -p $DockerHubPass
    docker tag ${image_name}:${image_tag} $DockerHubUser/${image_name}:${image_tag}
    docker push $DockerHubUser/${image_name}:${image_tag}
    """
  }
}
