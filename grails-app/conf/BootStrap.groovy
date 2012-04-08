import boil.*

class BootStrap {

	def fixtureLoader

    def init = { servletContext ->
		
		if (!ShiroUser.list()) {
			fixtureLoader.load('users-roles', 'joda')
		}
    }
    def destroy = {
    }
}
