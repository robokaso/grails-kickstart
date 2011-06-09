/**
 * Makes sure the app started up successfully.
 * 
 * @author Robert Kasanicky
 */
class WelcomeSpec extends BaseSpec {

	def 'ping index'() {
		
		expect:
			$('title').text() == 'Welcome to Grails'
	}
}
