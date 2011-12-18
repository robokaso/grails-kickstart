import org.apache.shiro.crypto.hash.Sha256Hash

import boil.*

String pwdHash = new Sha256Hash('test')

fixture {
	
	roleSuperuser(ShiroRole, name: 'SUPERUSER') {
		permissions = ['*']
	}
	
	userSuper(ShiroUser) {
		username = "super"
		passwordHash = pwdHash
		fullName = "Super User"
		email = "super@grails-boilerplate.org"
		roles = [roleSuperuser]
	}
}