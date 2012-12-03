package boil

import org.apache.shiro.subject.Subject
import org.grails.plugin.platform.security.SecurityBridge

class ShiroSecurityBridgeSpec extends AbstractShiroSpec {

	SecurityBridge grailsSecurityBridge

	/**
	 * Simulate login as superuser
	 */
	def setupSpec() {
		def subject = [
					getPrincipal: { 'super' },
					isAuthenticated: { true },
					isPermitted: { true },
					hasRole: { String role -> role == 'SUPER'},
					isPermitted: { String perm -> !(perm =~ 'forbiddenAction') }
				] as Subject
		setSubject(subject)
	}

	void 'provider name is Shiro'() {
		
		expect:
			grailsSecurityBridge.providerName == 'Shiro'
	}

	void 'get user identity of logged user'() {
		
		expect:
			grailsSecurityBridge.userIdentity == 'super'
	}
	
	void 'user info'() {
		
		when:
			def userInfo = grailsSecurityBridge.userInfo
		then:
			userInfo instanceof ShiroUser
			userInfo.username == 'super'
			userInfo.fullName == 'Super User'
			
	}
	
	void 'user has role'() {
		
		expect:
			grailsSecurityBridge.userHasRole('SUPER')
			!grailsSecurityBridge.userHasRole('JUNIOR')
	}
	
	void 'user is allowed'() {
		
		expect:
			grailsSecurityBridge.userIsAllowed('person', 'create')	
			!grailsSecurityBridge.userIsAllowed('person', 'forbiddenAction')	
	}
	
	void 'create links'() {
		
		expect:
			grailsSecurityBridge.createLink('login') == [controller: 'auth', action: 'login']
			grailsSecurityBridge.createLink('logout') == [controller: 'auth', action: 'signOut']
		
	}

	void 'user exsits'() {
		expect: "only usernames of registered users are accepted"
			grailsSecurityBridge.userExists('super')	
			!grailsSecurityBridge.userExists('notExistant')	
			!grailsSecurityBridge.userExists(new Object())	

	}
	
}
