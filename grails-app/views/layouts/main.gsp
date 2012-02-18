<html>
<head>
<title><g:layoutTitle default="${meta(name: 'app.name') }"/></title>
<meta name="layout" content="main" />
<r:require module="scaffolding" />
<r:layoutResources />
<g:layoutHead/>
</head>

<body>
	<header class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="/"><g:meta name="app.name" /></a>
				<div class="nav-collapse">

					<ul class="nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a
							href="https://github.com/robokaso/grails-kickstart#readme">About</a></li>
						<li><a href="https://github.com/robokaso">Contact</a></li>
					</ul>
					<p class="navbar-text pull-right">
						<shiro:isLoggedIn>
		         		Logged in as <g:link controller="user" action="profile">
								<shiro:principal />
							</g:link> &nbsp; &nbsp;
		         		<g:link controller="auth" action="signOut">Logout</g:link>
						</shiro:isLoggedIn>
						<shiro:notUser>
							<g:link controller="auth" action="login">Login</g:link>
						</shiro:notUser>
					</p>
				</div>
			</div>
		</div>
	</header>
	
	<div class="container-fluid">
		<div class="row-fluid">
			<section class="span3">
				<nav class="well sidebar-nav">
					<h5>Admin</h5>
					<ul>
						<li><g:link elementId="monitoring" controller="monitoring">Monitoring</g:link></li>
						<li><g:link elementId="console" controller="console">Console</g:link></li>
						<li><g:link elementId="greenmail" controller="greenmail" action="list.html" >Greenmail</g:link></li>
						<li><g:link elementId="logging" controller="runtimeLogging">Logging</g:link></li>
					</ul>
					<h5>Application status</h5>
					<ul>
						<li>Grails version: <g:meta name="app.grails.version" /></li>
						<li>Groovy version: ${org.codehaus.groovy.runtime.InvokerHelper.getVersion()}</li>
						<li>JVM version: ${System.getProperty('java.version')}</li>
						<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
						<li>Domains: ${grailsApplication.domainClasses.size()}</li>
						<li>Services: ${grailsApplication.serviceClasses.size()}</li>
						<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
					</ul>
				</nav>
			</section>
			<section class="span9">
				<g:layoutBody/>
			</section>
		</div>

		<hr />
		<footer>
			Build:
			<g:meta name="build.id" />
		</footer>
	</div>

	<r:layoutResources />
</body>

</html>