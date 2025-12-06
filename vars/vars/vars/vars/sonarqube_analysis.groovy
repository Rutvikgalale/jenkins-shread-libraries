def call(String SonarQubeserver, String Projectname, String ProjectKey){
  withSonarQubeEnv("${SonarQubeserver}"){
    sh "$SONAR_HOME/bin/sonar-scanner -Dsonar.projectName=${Projectname} -Dsonar.projectKey=${ProjectKey} -X"
}
