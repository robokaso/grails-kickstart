
/**
 * Makes sure the app started up successfully.
 * 
 * @author Robert Kasanicky
 */
class WelcomeSpec extends GebWorkaroundSpec {

	def 'ping index'() {
		
		when:
			go()
			
		then:
			$('title').text() == 'Welcome to Grails'
	}
}
