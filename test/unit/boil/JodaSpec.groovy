package boil

import grails.test.mixin.*

import org.joda.time.*

import spock.lang.Specification

@Mock(Joda)
class JodaSpec extends Specification {

	Joda joda = new Joda()
	
	def 'mocking joda time'() {
		
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
