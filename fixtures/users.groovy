import org.apache.shiro.crypto.hash.Sha256Hash

fixture {
	
	roleAdmin(ShiroRole) {
		name = 'Administrator'
		permissions = ["*:*"]
	}

	userAdmin(ShiroUser) {
		firstName = "Administator"
		lastName = "User"
		username = 'admin'
		passwordHash = new Sha256Hash("changeit").toHex()
		email = 'someone@gmail.com'
		roles = [ref('roleAdmin')]
	}
}





