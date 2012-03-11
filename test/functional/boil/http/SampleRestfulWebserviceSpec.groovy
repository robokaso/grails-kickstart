package boil.http

import org.springframework.http.HttpStatus


import grails.plugins.rest.client.RestBuilder
import spock.lang.Specification

class SampleRestfulWebserviceSpec extends Specification {

	def rest = new RestBuilder()

	def 'sample'() {
		
		when:
			def resp = rest.get('http://localhost:8080')

		then:
			resp.statusCode == HttpStatus.OK

	}
}
