
/**
 * Checks JavaMelody monitoring is in place.
 * 
 * @author Robert Kasanicky
 */
class MonitoringSpec extends BaseSpec {

	@Override
	String getBaseUrl() {
		super.getBaseUrl() + '/monitoring'
	}
	
	def 'ping the monitoring page'() {
		expect:
			$('title').text().startsWith('Monitoring JavaMelody')
	}
	
	

}
