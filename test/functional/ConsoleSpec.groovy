
/**
 * Checks the grails console is accessible.
 * 
 * @author Robert Kasanicky
 */
class ConsoleSpec extends GebWorkaroundSpec {
	
	
	def 'ping console'() {
		
		when:
			go('/console')
			
		then:
			$('title').text() == 'Grails Console'	
	}

}
