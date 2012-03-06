package boil.support

import geb.spock.GebReportingSpec

/**
 * Handles login & logout routine needed for many test scenarios.
 * 
 * @author Robert Kasanicky
 *
 */
class AuthenticatedSpec extends GebReportingSpec {

	def setup() {
		clearCookies()
		baseUrl = baseUrl ?: 'http://localhost:8080/'
		go '/auth/login'
		assert $('title').text() =~ "Login"

		def form = $('form')
		form.username = 'super'
		form.password = 'test'

		$('input', type: 'submit').click()
		assert $('title').text() =~ "grails"
	}

	def cleanup() {
		clearCookies()
	}
}
