<h2>WARNING</h2>

This projects targets Grails 2.0 which is under development, don't use this for anything serious just yet.

Anyway take a look at the <code>BuildConfig.groovy</code> for an inspiration about which plugins you may want to
consider using and how to configure them in <code>Config.groovy</code>.

<h2>About</h2>

Aims to provide a template that helps to kick-start a best-practice grails projects. 

While the choices made are inevitably opinionated the project should still be generally useful:

* for beginners as a rich set of sensible defaults
* for advanced users as a concrete basis for discussing/reevaluating the choices made and pointing out
	additional plugins with orthogonal functionalities that improve the overall experience.
* as an integration test proving that the chosen set of plugins works together nicely or 
	showcase the necessary workarounds in case it doesn't

<h2>Known issues</h2>

* [Spock dependency error](http://jira.grails.org/browse/GPSPOCK-2?focusedCommentId=64393&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-64393)
* [Class diagram doesn't show correctly](http://jira.grails.org/browse/GPCLASSDIAGRAM-16)

<h2>TODO</h2>
* security + user admin UI
* nice scaffolding UI (perhaps grails will take care) + Joda support
* coffeescript support
* CI + deployment - is there a good way to make the configs public & kept up-to-date automatically?
