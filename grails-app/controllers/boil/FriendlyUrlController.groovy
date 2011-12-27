package boil

/**
 * Test for hyphenated URLs (<code>/hello-world</code> rather than <code>helloWorld</code>).
 * 
 * @author Robert Kasanicky
 *
 */
class FriendlyUrlController {

	static defaultAction = "index"
	
	def index = {
		render "<p>Hello World</p>"
	}
}
