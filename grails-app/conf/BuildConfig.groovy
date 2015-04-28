grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.war.file = "target/kickstart.war"

grails.project.source.level = 1.6
grails.project.target.level = 1.6

grails.project.dependency.resolver = "maven"

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
	
	final GEB_VERSION = "0.10.0"
	final SELENIUM_VERSION = "2.45.0"
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
		

		compile ":asset-pipeline:2.1.5"
		compile ":less-asset-pipeline:2.1.0"
		compile ":cache:1.1.8"
		
		compile ":twitter-bootstrap:3.3.4"
		compile ":font-awesome-resources:4.3.0.1"
        compile ":jquery:1.11.1"

		compile ":scaffolding:2.1.1"
		
		// compile ':fields:1.3'
		
		// why Shiro rather than Spring Security 
		// http://www.katasoft.com/blog/2011/05/09/new-rbac-resource-based-access-control
		compile(":shiro:1.2.1") {
			excludes 'servlet-api'
		}
		compile ":joda-time:1.5"
		compile(":mail:1.0.7") {
			excludes 'spring-test'
		}
		compile ":greenmail:1.3.4"
		compile ':rest-client-builder:2.1.1'
		
		compile ':platform-core:1.0.0'

		runtime ":hibernate:3.6.10.19"
		runtime ":console:1.5.4"
		runtime ":fixtures:1.3"
		runtime ":build-test-data:2.4.0"
		
		test ":geb:$GEB_VERSION"
		test ":code-coverage:2.0.3-3"

		build(":codenarc:0.23") {
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
