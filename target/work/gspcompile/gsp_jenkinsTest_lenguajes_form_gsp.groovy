import lenguajes.Lenguajes
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_jenkinsTest_lenguajes_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lenguajes/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: lenguajesInstance, field: 'conclusion', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("lenguajes.conclusion.label"),'default':("Conclusion")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("conclusion"),'value':(lenguajesInstance?.conclusion)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lenguajesInstance, field: 'ejemplo', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("lenguajes.ejemplo.label"),'default':("Ejemplo")],-1)
printHtmlPart(2)
invokeTag('textField','g',18,['name':("ejemplo"),'value':(lenguajesInstance?.ejemplo)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lenguajesInstance, field: 'experiencia', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("lenguajes.experiencia.label"),'default':("Experiencia")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['name':("experiencia"),'value':(lenguajesInstance?.experiencia)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lenguajesInstance, field: 'lenguaje', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("lenguajes.lenguaje.label"),'default':("Lenguaje")],-1)
printHtmlPart(2)
invokeTag('textField','g',34,['name':("lenguaje"),'value':(lenguajesInstance?.lenguaje)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1399679030000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
