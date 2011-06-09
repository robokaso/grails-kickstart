/**
 * Checks the grails console is accessible.
 * 
 * @author Robert Kasanicky
 */
class ConsoleSpec extends BaseSpec {
	
	@Override
	String getBaseUrl() {
		super.getBaseUrl() + '/console' 
	}
	
	def 'ping console'() {
		
		expect:
			$('title').text() == 'Grails Console'	
	}

}
