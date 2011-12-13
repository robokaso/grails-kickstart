package boil


import org.joda.time.*

import spock.lang.Specification

/**
 * Persisting Joda classes via hibernate.
 * 
 * @author Robert Kasanicky
 */
class JodaIntegrationSpec extends Specification {

	def joda = new Joda()
	
	def 'persisting joda-time'() {
		
		setup: 'set joda-time attributes'
			joda.with {
				dateTime = new DateTime()
				localDate = new LocalDate()
				duration = new Duration(dateTime, dateTime.plusHours(1))
			}
		
		expect: 'successful save and retrieval'
			joda.save(failOnError:true)
			Joda.get(joda.id) == joda
	}
}
