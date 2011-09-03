grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        mavenLocal()
        mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.5'
		
		test("org.seleniumhq.selenium:selenium-htmlunit-driver:2.5.0") {
			exclude 'xml-apis'
		}
		test "org.codehaus.geb:geb-spock:0.6.0"
		
		//see http://jira.grails.org/browse/GPJODATIME-10
		compile("joda-time:joda-time-hibernate:1.3") {
			excludes "joda-time", "hibernate"
		}
		
    }

    plugins {
        compile ":hibernate:$grailsVersion"
        compile ":jquery:1.6.1.1"
		compile ":jquery-ui:1.8.15"
        compile ":resources:1.0.2"
		compile(":joda-time:1.2") {
				//see http://jira.grails.org/browse/GPJODATIME-10
				excludes "joda-time-hibernate"
		}

//		FIXME http://jira.grails.org/browse/GPCLASSDIAGRAM-16
		compile ":class-diagram:0.5.2"
		
		
//		FIXME http://jira.grails.org/browse/GPCONSOLE-2
		runtime ":console:1.0.1"
		runtime ":fixtures:1.0.7"
		runtime ":grails-melody:1.7"
		
		test ":spock:0.6-SNAPSHOT"
		test ":geb:0.6.0"
		test ":code-coverage:1.2.4"
		
		build ":codenarc:0.15"
		
		build ":eclipse-scripts:1.0.5"
        build ":tomcat:$grailsVersion"
		
    }
}

coverage {
	enabledByDefault = false
	nopost = true
	xml = true
	exclusions = [
			'**/*plugin*/**',
			'**/grails/**',
			'**/junit/**',
			'**/com/**',
			'**/org/**',
			'**/scheduledjobs/**',
			'*Config*',
			'*Codec*',
			'*Diagram*',
			'*Builder*',
			'*Searchable*',
			'*Nimble*',
			'*Shiro*',
			'*TagLib*',
			'JQuery*',
	]
}
