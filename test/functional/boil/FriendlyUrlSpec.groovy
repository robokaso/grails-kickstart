package boil

import boil.support.AuthenticatedSpec

class FriendlyUrlSpec extends AuthenticatedSpec {

	void 'URL hyphenation'() {
		
		when:
			go('/friendly-url')
			
		then:
			$('p').text() == 'Hello World'
	}
}
