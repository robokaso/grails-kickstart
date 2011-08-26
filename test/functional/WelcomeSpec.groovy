import geb.spock.GebSpec

/**
 * Makes sure the app started up successfully.
 * 
 * @author Robert Kasanicky
 */
class WelcomeSpec extends GebSpec {

	def 'ping index'() {
		
		when:
			go()
			
		then:
			$('title').text() == 'Welcome to Grails'
	}
}
