grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.war.file = "target/kickstart.war"

grails.project.source.level = 1.6
grails.project.target.level = 1.6

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
		mavenRepo "http://repo.springsource.org/milestone/"
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
	
	final GEB_VERSION = "0.9.2"
	final SELENIUM_VERSION = "2.37.1"
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

		// test("org.seleniumhq.selenium:selenium-htmlunit-driver:$SELENIUM_VERSION") 
		test "org.seleniumhq.selenium:selenium-support:$SELENIUM_VERSION"
		test "org.seleniumhq.selenium:selenium-firefox-driver:$SELENIUM_VERSION"
//		test("org.seleniumhq.selenium:selenium-chrome-driver:$SELENIUM_VERSION")
		
		test "org.gebish:geb-spock:$GEB_VERSION"
		
		compile "org.jadira.usertype:usertype.jodatime:1.9.1"
		
    }

    plugins {
		
        compile ":resources:1.2.1"
		compile ':cached-resources:1.0'
		compile ':zipped-resources:1.0'
		compile ':cache-headers:1.1.5'
		
		compile ":less-resources:1.3.3.2"

		compile ":cache:1.1.1"
		
		compile ":twitter-bootstrap:2.3.2"
		compile ":font-awesome-resources:3.2.1.3"
        compile ":jquery:1.10.2"
		
		// compile ':fields:1.3'
		
		// why Shiro rather than Spring Security 
		// http://www.katasoft.com/blog/2011/05/09/new-rbac-resource-based-access-control
		compile(":shiro:1.2.0") {
			excludes 'servlet-api'
		}
		compile ":joda-time:1.4"
		compile(":mail:1.0.1") {
			excludes 'spring-test'
		}
		compile ":greenmail:1.3.4"
		compile ':rest-client-builder:2.0.0'
		
		compile ':platform-core:1.0.RC5'
		// problematic atmosphere-snapshot dependency
		// compile ':events-push:1.0.M7'
		
		runtime ":hibernate:3.6.10.2"
		runtime ":console:1.2"
		runtime ":fixtures:1.2"
		runtime ":build-test-data:2.0.6"
		
		/* problem with security http://jira.grails.org/browse/GPMELODY-7 
		runtime ":grails-melody:1.14"
		*/
		
		runtime ":runtime-logging:0.4"
		
		test ":geb:$GEB_VERSION"
		test ":code-coverage:1.2.6"
		test ':functional-test-development:0.9.4'
		test ":remote-control:1.4"
//		test ':auto-test:1.0.1'
		
		build(":codenarc:0.19") {
			excludes 'groovy-all'
		}

        build ":tomcat:7.0.42"
		
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
			'*Resources*',
			'changelog*',
			'0*', //database migrations
	]
}

codenarc {
	//switch to xml format once Jenkins Violations don't throw exceptions on the output
	reportType = 'xml'
	reportName = 'target/codenarc.xml'
}
