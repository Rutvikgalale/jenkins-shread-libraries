def call(String url, String branch){
  echo "this is cloning code"
  git url: url, git branch: branch 
  echo "code cloned successful"
}  
