def call(String image_name, String image_tag, port){
  echo "This is Deploying code"
  sh '''
  # Stop old container by name if exists
  #docker stop notes-app || true
  #docker rm notes-app || true
  # Stop any container occupying port 8000
  old=$(docker ps -aq --filter "publish=$port")
  if [ -n "$old" ]; then
  echo "Stopping containers using port $port..."
  docker stop $old || true
  docker rm $old || true
  fi
  /usr/bin/docker run -dit -p port:port ${image_name}:${image_tag}
  '''
}
