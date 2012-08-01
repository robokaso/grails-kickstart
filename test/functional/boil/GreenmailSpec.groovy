package boil

import boil.support.AuthenticatedSpec

class GreenmailSpec extends AuthenticatedSpec {

	void mailbox() {
		
		when:
			$('#greenmail').click()
			
		then:
			title == 'Email List'
			$('h2').text() == 'Email List'
	}
}
