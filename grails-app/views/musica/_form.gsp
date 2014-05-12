<%@ page import="musica.Musica" %>



<div class="fieldcontain ${hasErrors(bean: musicaInstance, field: 'banda', 'error')} ">
	<label for="banda">
		<g:message code="musica.banda.label" default="Banda" />
		
	</label>
	<g:textField name="banda" value="${musicaInstance?.banda}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: musicaInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="musica.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${musicaInstance?.nombre}"/>
</div>

