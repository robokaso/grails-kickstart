// add Jenkins metadata to application.properties
eventCreateWarStart = { warName, stagingDir ->
	
	Map env = System.getenv()
	def buildNumber = env['BUILD_NUMBER'] ?: 'NA'
	def buildId = env['BUILD_ID'] ?: 'NA'
	def gitCommit = env['GIT_COMMIT'] ?: 'NA'
	
	ant.propertyfile(
	   file:"${stagingDir}/WEB-INF/classes/application.properties") {
		 entry(key:'build.number', value:buildNumber)
		 entry(key:'build.id', value:buildId)
		 entry(key:'build.commit', value:gitCommit)
   }
}