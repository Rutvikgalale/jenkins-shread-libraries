def call(String image_name, String image_tag, String DockerHubUser){
  echo "This is building code
  sh "docker build -t ${DockerHubUser}/${image_name}:${image_tag} . "
  echo "docker build successfull"
}
