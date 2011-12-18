package boil

import org.joda.time.DateTime

class ShiroUser {
	
    String username
    String passwordHash
	
	DateTime dateCreated 
	DateTime lastUpdated 
	
	String fullName
	
	String email
	
	boolean enabled = true
	
    
    static hasMany = [ roles: ShiroRole, permissions: String ]

    static constraints = {
        username nullable: false, blank: false, unique:true
		fullName blank:false
		email 	 email:true
    }
}
