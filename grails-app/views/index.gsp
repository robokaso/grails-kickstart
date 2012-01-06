<html>
<head>
	<title><g:meta name="app.name"/></title>
	<r:require module="style" />
	<r:layoutResources/>
</head>
	
<body>
	<header class="topbar">
		<div class="topbar-inner">
			<div class="container-fluid">
	          <a class="brand" href="/"><g:meta name="app.name" /></a>
	          <ul class="nav">
	            <li class="active"><a href="#">Home</a></li>
	            <li><a href="#about">About</a></li>
	            <li><a href="#contact">Contact</a></li>
	          </ul>
	          <p class="pull-right">
	          	<shiro:isLoggedIn>
	         		Logged in as <g:link controller="user" action="profile"><shiro:principal/></g:link> &nbsp; &nbsp;
	         		<g:link controller="auth" action="signOut">Logout</g:link>
	          	</shiro:isLoggedIn>
	          	<shiro:notUser>
	          		<g:link controller="auth" action="login">Login</g:link>	
	          	</shiro:notUser>
	          </p>
	        </div>
		</div>	
	</header>

	<div class="container-fluid">
		<section class="sidebar">
			<nav class="well">
				<h5>Admin</h5>
				<ul>
					<li><g:link elementId="monitoring" controller="monitoring">Monitoring</g:link></li>	
					<li><g:link elementId="console" controller="console">Console</g:link></li>	
				</ul>
				<h5>Application status</h5>
				<ul>
					<li>App version: <g:meta name="app.version"/></li>
					<li>Grails version: <g:meta name="app.grails.version"/></li>
					<li>Groovy version: ${org.codehaus.groovy.runtime.InvokerHelper.getVersion()}</li>
					<li>JVM version: ${System.getProperty('java.version')}</li>
					<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
					<li>Domains: ${grailsApplication.domainClasses.size()}</li>
					<li>Services: ${grailsApplication.serviceClasses.size()}</li>
					<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
				</ul>
				
			</nav>
		</section>	
		<section class="content">
		
			<article class="hero-unit">
				<h1>Welcome to Grails Kickstart</h1>
				<p>Valid credentials are <strong>super/test</strong></p>
	
				<div id="controller-list" role="navigation">
					<h2>Available Controllers:</h2>
					<ul>
						<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.name } }">
							<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.name}</g:link></li>
						</g:each>
					</ul>
				</div>
			</article>
		
			<footer>@Copy Left Right Up Down, Build: <g:meta name="build.id" /></footer>
		</section>
	</div>
	
	
	
	<r:layoutResources/>
</body>

</html>