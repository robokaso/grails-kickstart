package boil.support

/**
 * Handles login & logout routine needed for many test scenarios.
 * 
 * @author Robert Kasanicky
 *
 */
class AuthenticatedSpec extends GebWorkaroundSpec {

	def setup() {
		clearCookies()
		baseUrl = baseUrl ?: 'http://localhost:8080/'
		go '/auth/login'
		assert $('title').text() =~ "Login"

		def form = $('form')
		form.username = 'super'
		form.password = 'test'

		$('input', type: 'submit').click()
		assert $('title').text() =~ "Grails"
	}

	def cleanup() {
		clearCookies()
	}
}
