import peliculas.Peliculas
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_jenkinsTest_peliculas_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/peliculas/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: peliculasInstance, field: 'director', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("peliculas.director.label"),'default':("Director")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("director"),'value':(peliculasInstance?.director)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: peliculasInstance, field: 'nombre', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("peliculas.nombre.label"),'default':("Nombre")],-1)
printHtmlPart(2)
invokeTag('textField','g',18,['name':("nombre"),'value':(peliculasInstance?.nombre)],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1399679063000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
