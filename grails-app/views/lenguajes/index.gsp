
<%@ page import="lenguajes.Lenguajes" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lenguajes.label', default: 'Lenguajes')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-lenguajes" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-lenguajes" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="conclusion" title="${message(code: 'lenguajes.conclusion.label', default: 'Conclusion')}" />
					
						<g:sortableColumn property="ejemplo" title="${message(code: 'lenguajes.ejemplo.label', default: 'Ejemplo')}" />
					
						<g:sortableColumn property="experiencia" title="${message(code: 'lenguajes.experiencia.label', default: 'Experiencia')}" />
					
						<g:sortableColumn property="lenguaje" title="${message(code: 'lenguajes.lenguaje.label', default: 'Lenguaje')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${lenguajesInstanceList}" status="i" var="lenguajesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${lenguajesInstance.id}">${fieldValue(bean: lenguajesInstance, field: "conclusion")}</g:link></td>
					
						<td>${fieldValue(bean: lenguajesInstance, field: "ejemplo")}</td>
					
						<td>${fieldValue(bean: lenguajesInstance, field: "experiencia")}</td>
					
						<td>${fieldValue(bean: lenguajesInstance, field: "lenguaje")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${lenguajesInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
