import org.apache.shiro.crypto.hash.Sha256Hash

import boil.*

String pwdHash = new Sha256Hash('test')

fixture {
	
	roleSuperuser(ShiroRole, name: 'SUPERUSER') {
		permissions = ['*']
	}
	
	build {
		userSuper(ShiroUser) {
			username = "super"
			passwordHash = pwdHash
			fullName = "Super User"
			//dummy value will be generated by Build Test Data Plugin
			//email = "super@grails-boilerplate.org"
			roles = [roleSuperuser]
		}
	}
}