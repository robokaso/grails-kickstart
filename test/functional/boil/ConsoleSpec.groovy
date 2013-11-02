package boil

import boil.support.AuthenticatedSpec

/**
 * Checks the grails console is accessible.
 * 
 * @author Robert Kasanicky
 */
class ConsoleSpec extends AuthenticatedSpec {
	
	
	void 'ping console'() {
		
		when:
			go('/console')
			
		then:
			title == 'Grails Console'	
	}

}
