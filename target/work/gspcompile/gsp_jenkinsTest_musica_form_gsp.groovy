import musica.Musica
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_jenkinsTest_musica_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/musica/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: musicaInstance, field: 'banda', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("musica.banda.label"),'default':("Banda")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("banda"),'value':(musicaInstance?.banda)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: musicaInstance, field: 'nombre', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("musica.nombre.label"),'default':("Nombre")],-1)
printHtmlPart(2)
invokeTag('textField','g',18,['name':("nombre"),'value':(musicaInstance?.nombre)],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1399679047000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
