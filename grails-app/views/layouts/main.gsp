<html>
<head>
<title><g:layoutTitle default="${meta(name: 'app.name') }"/></title>
<meta name="layout" content="main" />
<asset:javascript src="application.js"/>
<asset:stylesheet src="application.css"/>
<g:layoutHead/>
</head>

<body>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/"><g:meta name="app.name" /></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><g:link controller="joda">Joda CRUD</g:link></li>
				<li><a
						href="https://github.com/robokaso/grails-kickstart#readme">About</a></li>
				<li><a href="https://github.com/robokaso">Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<shiro:isLoggedIn>
					<li><g:link controller="user" action="profile"> <s:identity/> </g:link> &nbsp; &nbsp;
					<li><a href="${s.createLogoutLink() }">Logout</a></li>
				</shiro:isLoggedIn>
				<shiro:notUser>
					<li><a href="${s.createLoginLink() }">Login</a></li>
				</shiro:notUser>
			</ul>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>
	
	<div class="container-fluid">
		<div class="row-fluid">
			<section class="col-sm-3">
				<nav class="well sidebar-nav">
				<cache:block>
					<h5>Admin</h5>
					<ul>
						<li><g:link elementId="console" controller="console">Console</g:link></li>
						<li><g:link elementId="greenmail" controller="greenmail" action="list" >Greenmail</g:link></li>
					</ul>
					<h5>Application status</h5>
					<ul>
						<li>Grails version: <g:meta name="app.grails.version" /></li>
						<li>Groovy version: ${groovy.lang.GroovySystem.getVersion()}</li>
						<li>JVM version: ${System.getProperty('java.version')}</li>
						<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
						<li>Domains: ${grailsApplication.domainClasses.size()}</li>
						<li>Services: ${grailsApplication.serviceClasses.size()}</li>
						<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
					</ul>
					<h5>Installed Plugins</h5>
					<ul>
						<g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
							<li>${plugin.name} - ${plugin.version}</li>
						</g:each>
					</ul>
				</cache:block>
				</nav>
			</section>
			<section class="col-sm-9">
				<g:layoutBody/>
			</section>
		</div>

		<hr />
		<footer>
			<span id="buildInfo">Build: <g:meta name="build.id" /></span>
			<span id="copyright">Copyleft 2011 - <p:year/> </span>
		</footer>
	</div>

</body>

</html>