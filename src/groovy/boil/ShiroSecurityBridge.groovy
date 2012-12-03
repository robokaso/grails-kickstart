package boil

import org.apache.shiro.SecurityUtils
import org.grails.plugin.platform.security.SecurityBridge

/**
 * Bridges Shiro to Grails Platform.
 * 
 * @author Robert Kasanicky
 *
 */
class ShiroSecurityBridge implements SecurityBridge {

	@Override
	String getProviderName() {
		"Shiro"
	}

	@Override
	String getUserIdentity() {
		SecurityUtils.subject.principal
	}

	@Override
	Object getUserInfo() {
		ShiroUser.findByUsername(SecurityUtils.subject.principal)
	}

	@Override
	boolean userHasRole(Object role) {
		SecurityUtils.subject.hasRole(role.toString())
	}

	@Override
	boolean userIsAllowed(Object object, Object action) {
		SecurityUtils.subject.isPermitted("${object}:${action}")
	}

	@Override
	Map createLink(String action) {
		def r = [controller:'auth']
		switch (action) {
			case 'login': r.action = "login"; break;
			case 'logout': r.action = "signOut"; break;
//			case 'signup': r.action = "signup"; break;
			default:
				throw new IllegalArgumentException('Security link [$action] is not recognized')
		}
		return r
	}

	@Override
	Object withUser(Object identity, Closure code) {
		SecurityUtils.subject.runAs(identity)
		try {
			code()
		}
		finally {
			SecurityUtils.subject.releaseRunAs()
		}
	}

	@Override
	boolean userExists(Object identity) {
		def username = identity.toString()
		ShiroUser.findByUsername(username) ? true : false
	}

}
