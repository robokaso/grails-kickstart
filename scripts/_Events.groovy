
eventCreateWarStart = { warName, stagingDir ->
	
	Map env = System.getenv()
	def buildNumber = env['BUILD_NUMBER'] ?: 'NA' 
	def buildId = env['BUILD_ID'] ?: "Local Build ${new Date()}"
	def revision = env['GIT_REVISION'] ?: 'NA'
	
	println("Setting BUILD_NUMBER to $buildNumber")
	ant.propertyfile(
	   file:"${stagingDir}/WEB-INF/classes/application.properties") {
		 entry(key:'build.number', value:buildNumber)
		 entry(key:'build.id', value:buildId)
		 entry(key:'build.revision', value:revision)
   }
}