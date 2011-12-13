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

		final SELENIUM_VERSION = "2.15.0"
		test "org.seleniumhq.selenium:selenium-support:$SELENIUM_VERSION"
		test "org.seleniumhq.selenium:selenium-firefox-driver:$SELENIUM_VERSION"
//		test("org.seleniumhq.selenium:selenium-chrome-driver:$SELENIUM_VERSION")
		
		test "org.codehaus.geb:geb-spock:0.6.1"
		
		compile "org.jadira.usertype:usertype.jodatime:1.9"
		
    }

    plugins {
        compile ":resources:1.1.5"
        compile ":jquery:1.7.1"
		compile ":jquery-ui:1.8.15"
		compile ":joda-time:1.3"
		
//		TODO try out
//		compile ":less-resources:0.6.1
//		compile ":twitter-bootstrap:1.4.0.12"
//		compile ":jquery-ui-widget:0.1.3"
//		compile ":taxonomy:1.1"
//		compile ":coffeescript-resources:0.2"

//		FIXME http://jira.grails.org/browse/GPCLASSDIAGRAM-16
//		compile ":class-diagram:0.5.2"
		
        runtime ":hibernate:$grailsVersion"
		runtime ":console:1.0.1"
		runtime ":fixtures:1.1"
		runtime ":grails-melody:1.10"
		
		test ":spock:0.6-SNAPSHOT"
		test ":geb:0.6.1"
		test ":code-coverage:1.2.5"
		
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
