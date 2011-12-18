package boil

import boil.support.AuthenticatedSpec

/**
 * Checks the grails console is accessible.
 * 
 * @author Robert Kasanicky
 */
class ConsoleSpec extends AuthenticatedSpec {
	
	
	def 'ping console'() {
		
		when:
			go('/console')
			
		then:
			$('title').text() == 'Grails Console'	
	}

}
