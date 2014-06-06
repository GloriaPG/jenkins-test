import lenguajes.Lenguajes
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_jenkinsTest_lenguajesindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lenguajes/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'lenguajes.label', default: 'Lenguajes'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',27,['property':("conclusion"),'title':(message(code: 'lenguajes.conclusion.label', default: 'Conclusion'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("ejemplo"),'title':(message(code: 'lenguajes.ejemplo.label', default: 'Ejemplo'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',31,['property':("experiencia"),'title':(message(code: 'lenguajes.experiencia.label', default: 'Experiencia'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',33,['property':("lenguaje"),'title':(message(code: 'lenguajes.lenguaje.label', default: 'Lenguaje'))],-1)
printHtmlPart(14)
loop:{
int i = 0
for( lenguajesInstance in (lenguajesInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: lenguajesInstance, field: "conclusion"))
})
invokeTag('link','g',41,['action':("show"),'id':(lenguajesInstance.id)],3)
printHtmlPart(17)
expressionOut.print(fieldValue(bean: lenguajesInstance, field: "ejemplo"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: lenguajesInstance, field: "experiencia"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: lenguajesInstance, field: "lenguaje"))
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
invokeTag('paginate','g',54,['total':(lenguajesInstanceCount ?: 0)],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',57,[:],1)
printHtmlPart(21)
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
