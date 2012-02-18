package boil

import boil.support.AuthenticatedSpec

class LoggingSpec extends AuthenticatedSpec {

	def logging() {
		
		when:
			$('#logging').click()
			
		then:
			title == 'Set Logging Levels'
			$('h1').text() == 'Set Logging Levels'
	}
}
