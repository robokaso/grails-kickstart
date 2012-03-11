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
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
	
	final GEB_VERSION = "0.6.3"
	final SELENIUM_VERSION = "2.20.0"
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

		// using HTMLunit instead of real-world browser due to build server limitations
		test("org.seleniumhq.selenium:selenium-htmlunit-driver:$SELENIUM_VERSION") 
		test "org.seleniumhq.selenium:selenium-support:$SELENIUM_VERSION"
//		test "org.seleniumhq.selenium:selenium-firefox-driver:$SELENIUM_VERSION"
//		test("org.seleniumhq.selenium:selenium-chrome-driver:$SELENIUM_VERSION")
		
		test "org.codehaus.geb:geb-spock:$GEB_VERSION"
		
		compile "org.jadira.usertype:usertype.jodatime:1.9"
		
    }

    plugins {
		
        compile ":resources:1.1.6"
		compile ':cached-resources:1.0'
		compile ':zipped-resources:1.0'
		compile ':cache-headers:1.1.5'
		
        compile ":jquery:1.7.1"
		
		//causes trouble on the build server due to dependency resolution timeouts
		compile ":lesscss-resources:1.0.1"
		compile ":twitter-bootstrap:2.0.1.21"
		
		// why Shiro rather than Spring Security 
		// http://www.katasoft.com/blog/2011/05/09/new-rbac-resource-based-access-control
		compile ":shiro:1.1.3" 
		compile ":joda-time:1.4"
		compile ":mail:1.0"
		compile ":greenmail:1.3.2"
		
		compile ':cloud-foundry:1.2.1'
		compile ':cloud-support:1.0.9'
		
		compile ':fields:1.0.4'
		
		
//		TODO CSS compatibility with Twitter Bootstrap	
//		compile ":jquery-ui:1.8.15"
//		TODO try out
//		compile ":jquery-ui-widget:0.1.3"
//		compile ":taxonomy:1.1"
//		compile ":coffeescript-resources:0.2"

//		FIXME http://jira.grails.org/browse/GPCLASSDIAGRAM-16
//		compile ":class-diagram:0.5.2"
		
        runtime ":hibernate:$grailsVersion"
		runtime ":console:1.1"
		runtime ":fixtures:1.1"
		runtime ":build-test-data:2.0.2"
		runtime ":grails-melody:1.12"
		runtime ":runtime-logging:0.4"
		
		test ":spock:0.6"
		test ":geb:$GEB_VERSION"
		test ":code-coverage:1.2.5"
		test ':functional-test-development:0.2'
		test ':auto-test:1.0'
		
		build ":codenarc:0.16.1"
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
