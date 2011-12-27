package boil

import boil.support.AuthenticatedSpec

class FriendlyUrlSpec extends AuthenticatedSpec {

	def 'URL hyphenation'() {
		
		when:
			go('/friendly-url')
			
		then:
			$('p').text() == 'Hello World'
	}
}
