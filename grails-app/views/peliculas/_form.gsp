<%@ page import="peliculas.Peliculas" %>



<div class="fieldcontain ${hasErrors(bean: peliculasInstance, field: 'director', 'error')} ">
	<label for="director">
		<g:message code="peliculas.director.label" default="Director" />
		
	</label>
	<g:textField name="director" value="${peliculasInstance?.director}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: peliculasInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="peliculas.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${peliculasInstance?.nombre}"/>
</div>

