import geb.spock.GebSpec

/**
 * Checks JavaMelody monitoring is in place.
 * 
 * @author Robert Kasanicky
 */
class MonitoringSpec extends GebSpec {

	def 'ping the monitoring page'() {
		
		when:
			go('/monitoring')
			
		then:
			$('title').text().startsWith('Monitoring JavaMelody')
	}
	
	

}
