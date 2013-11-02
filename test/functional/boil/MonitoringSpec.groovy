package boil

import spock.lang.Ignore;
import boil.support.AuthenticatedSpec

/**
 * Checks JavaMelody monitoring is in place.
 * 
 * @author Robert Kasanicky
 */
@Ignore
class MonitoringSpec extends AuthenticatedSpec {

	void 'ping the monitoring page'() {
		
		when:
			go('/monitoring')
			
		then:
			title.startsWith('Monitoring JavaMelody')
	}
	
	

}
