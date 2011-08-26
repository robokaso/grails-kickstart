import grails.plugin.fixtures.FixtureLoader

class BootStrap {

	FixtureLoader fixtureLoader

    def init = { servletContext ->
		// load fixtures only on empty database
		if (!ShiroUser.list()) {
			fixtureLoader.load('users')
		}
    }
    def destroy = {
    }
}
