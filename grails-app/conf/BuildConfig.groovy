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
        //mavenCentral()
        mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.5'
		
		test("org.seleniumhq.selenium:selenium-htmlunit-driver:2.0b3") {
			exclude 'xml-apis'
		}
    }

    plugins {
        compile ":hibernate:$grailsVersion"
        compile ":jquery:1.6.1.1"
//		compile ":jquery-ui:1.8.11"
        compile ":resources:1.0"
		compile ":joda-time:1.2"

//		FIXME http://jira.grails.org/browse/GPCLASSDIAGRAM-16
		compile ":class-diagram:0.5.2"
		
//		FIXME http://jira.grails.org/browse/GPFIXTURES-19
//		runtime ":fixtures:1.0.6"
		
//		FIXME http://jira.grails.org/browse/GPCONSOLE-2
		runtime ":console:1.0.1"
		
		test ":spock:0.6-groovy-1.8-SNAPSHOT"
		test ":geb:0.5.1"
		test ":code-coverage:1.2.4"
		
		
//		FIXME http://jira.grails.org/browse/GPCODENARC-15
//		build ":codenarc:0.12"
		
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
