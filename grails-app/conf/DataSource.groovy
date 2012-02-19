dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop','update'
            url = "jdbc:h2:mem:devDb"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb"
        }
    }
    production {
		dataSource {
			jndiName = "java:comp/env/jdbc/grailskick"
		}
    }
	
	// Cloud Foundry
	cf {
		dataSource {
            dbCreate = "create-drop"
			driverClassName = "org.postgresql.Driver"
			dialect = net.sf.hibernate.dialect.PostgreSQLDialect
			url = ""
		}
	}
}
