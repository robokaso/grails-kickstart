package boil

import boil.support.AuthenticatedSpec

/**
 * Checks JavaMelody monitoring is in place.
 * 
 * @author Robert Kasanicky
 */
class MonitoringSpec extends AuthenticatedSpec {

	def 'ping the monitoring page'() {
		
		when:
			go('/monitoring')
			
		then:
			$('title').text().startsWith('Monitoring JavaMelody')
	}
	
	

}
