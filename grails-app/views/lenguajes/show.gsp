
<%@ page import="lenguajes.Lenguajes" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lenguajes.label', default: 'Lenguajes')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-lenguajes" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-lenguajes" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list lenguajes">
			
				<g:if test="${lenguajesInstance?.conclusion}">
				<li class="fieldcontain">
					<span id="conclusion-label" class="property-label"><g:message code="lenguajes.conclusion.label" default="Conclusion" /></span>
					
						<span class="property-value" aria-labelledby="conclusion-label"><g:fieldValue bean="${lenguajesInstance}" field="conclusion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lenguajesInstance?.ejemplo}">
				<li class="fieldcontain">
					<span id="ejemplo-label" class="property-label"><g:message code="lenguajes.ejemplo.label" default="Ejemplo" /></span>
					
						<span class="property-value" aria-labelledby="ejemplo-label"><g:fieldValue bean="${lenguajesInstance}" field="ejemplo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lenguajesInstance?.experiencia}">
				<li class="fieldcontain">
					<span id="experiencia-label" class="property-label"><g:message code="lenguajes.experiencia.label" default="Experiencia" /></span>
					
						<span class="property-value" aria-labelledby="experiencia-label"><g:fieldValue bean="${lenguajesInstance}" field="experiencia"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lenguajesInstance?.lenguaje}">
				<li class="fieldcontain">
					<span id="lenguaje-label" class="property-label"><g:message code="lenguajes.lenguaje.label" default="Lenguaje" /></span>
					
						<span class="property-value" aria-labelledby="lenguaje-label"><g:fieldValue bean="${lenguajesInstance}" field="lenguaje"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:lenguajesInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${lenguajesInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
