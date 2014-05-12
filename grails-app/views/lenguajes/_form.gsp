<%@ page import="lenguajes.Lenguajes" %>



<div class="fieldcontain ${hasErrors(bean: lenguajesInstance, field: 'conclusion', 'error')} ">
	<label for="conclusion">
		<g:message code="lenguajes.conclusion.label" default="Conclusion" />
		
	</label>
	<g:textField name="conclusion" value="${lenguajesInstance?.conclusion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lenguajesInstance, field: 'ejemplo', 'error')} ">
	<label for="ejemplo">
		<g:message code="lenguajes.ejemplo.label" default="Ejemplo" />
		
	</label>
	<g:textField name="ejemplo" value="${lenguajesInstance?.ejemplo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lenguajesInstance, field: 'experiencia', 'error')} ">
	<label for="experiencia">
		<g:message code="lenguajes.experiencia.label" default="Experiencia" />
		
	</label>
	<g:textField name="experiencia" value="${lenguajesInstance?.experiencia}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lenguajesInstance, field: 'lenguaje', 'error')} ">
	<label for="lenguaje">
		<g:message code="lenguajes.lenguaje.label" default="Lenguaje" />
		
	</label>
	<g:textField name="lenguaje" value="${lenguajesInstance?.lenguaje}"/>
</div>

