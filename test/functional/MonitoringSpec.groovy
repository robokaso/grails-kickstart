
/**
 * Checks JavaMelody monitoring is in place.
 * 
 * @author Robert Kasanicky
 */
class MonitoringSpec extends GebWorkaroundSpec {

	def 'ping the monitoring page'() {
		
		when:
			go('/monitoring')
			
		then:
			$('title').text().startsWith('Monitoring JavaMelody')
	}
	
	

}
