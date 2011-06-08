import grails.plugin.geb.GebSpec

/**
 * Convenience superclass for common specs to avoid repetitive setup.
 * 
 * @author Robert Kasanicky
 */
abstract class BaseSpec extends GebSpec{

	/**
	 * Allows the test to be run standalone (e.g. from IDE against running app)
	 * without bootstrapping Grails.
	 */
	@Override
	String getBaseUrl() {
		'http://localhost:8080/grails-boilerplate'
	}
	
	def setup() {
		go()
	}

}
