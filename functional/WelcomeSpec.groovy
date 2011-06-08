import grails.plugin.geb.GebSpec
import groovy.lang.MetaClass;

/**
 * Makes sure the app started up successfully.
 * 
 * @author Robert Kasanicky
 */
class WelcomeSpec extends GebSpec {

	/**
	 * Allows the test to be run standalone (e.g. from IDE against running app)
	 * without bootstrapping Grails.
	 */
	@Override
	String getBaseUrl() {
		'http://localhost:8080/grails-boilerplate'
	}

	def 'ping index'() {
		when:
		go()

		then:
		$('title').text() == 'Welcome to Grails'
	}
}
