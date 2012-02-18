package boil

import boil.support.AuthenticatedSpec

class GreenmailSpec extends AuthenticatedSpec {

	def logging() {
		
		when:
			$('#greenmail').click()
			
		then:
			title == 'Email List'
			$('h2').text() == 'Email List'
	}
}
