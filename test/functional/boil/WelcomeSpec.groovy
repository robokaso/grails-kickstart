package boil

import geb.spock.GebReportingSpec

/**
 * Makes sure the app started up successfully.
 * 
 * @author Robert Kasanicky
 */
class WelcomeSpec extends GebReportingSpec {

	def setup() {
		baseUrl = baseUrl ?: 'http://localhost:8080/'
	}
	
	void 'ping index'() {
		
		when:
			go()
			
		then:
			$('title').text() == 'grailskick'
	}
}
