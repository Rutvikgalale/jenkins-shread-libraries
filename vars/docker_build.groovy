def call(String imageName, String imageTag, String dockerHubUser) {
    echo "Building Docker image: ${dockerHubUser}/${imageName}:${imageTag}"
    sh """
        docker build -t ${dockerHubUser}/${imageName}:${imageTag} .
    """
    echo "Docker build successful"
}

