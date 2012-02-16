package sites

import org.springframework.web.servlet.support.RequestContextUtils
import org.codehaus.groovy.grails.web.pages.GroovyPagesTemplateEngine
import org.codehaus.groovy.grails.commons.GrailsControllerClass


class CommonsTagLib {
    def serverUrl= { attrs, body ->

        def urlBase
        if(request.isSecure()){
            urlBase = "https://"+request.getServerName()
        }else{
            urlBase = "http://"+request.getServerName()
        }
        if (request.getLocalPort() != 80) {
            urlBase = urlBase +":"+request.getLocalPort()
        }

        out << urlBase
    }
    
    def serverContextPath= { attrs, body ->
        out << request.contextPath
    }
    
    def serverUrlWithContextPath = { attrs, body ->
        out << serverUrl() + request.contextPath
    }
    
    def currentDomain={ attrs, body ->
        def serverName = request.getServerName()
        def index = serverName.lastIndexOf(".")
        if(index != -1)
            out << serverName.substring(index+1).toLowerCase()
    }
    
    def currentLang={ attrs, body ->
        def locale = RequestContextUtils.getLocale(request)
        def lang = locale.getLanguage() 
        out << lang
    }
        
    def renderByCurrentLang={attrs, body ->
        if(!attrs.template){
            throwTagError("Tag [render] is missing required attribute [template]")
        }
        def paramsMap = attrs
        def template = attrs.template + "_" + currentLang()
        
        def engine = groovyPagesTemplateEngine
        
        def uri = grailsAttributes.getTemplateUri(template,request)
        def contextPath = attrs.contextPath ? attrs.contextPath : ""
        def r = engine.getResourceForUri("${contextPath}${uri}")
        if(r.exists()){
            paramsMap.template = template
        }
        out << render(paramsMap)
    }
    
    def currentFormatDate = { attrs, body ->
            def date = attrs.date
            boolean onlyDate = attrs.onlyDate?new Boolean(attrs.onlyDate):false
            def i18nDate
            if(currentLang()=="es"){
                i18nDate = formatDate(format:'dd-MM-yyyy', date:date)
            }else{
                i18nDate = formatDate(format:'yyyy-MM-dd', date:date)
            }
            if(onlyDate){
                out << i18nDate
            }else{ 
                out << "${i18nDate} ${message(code:'at.hour')} ${formatDate(format:'HH:mm', date:date)}"
            }
            
    }
    
    def substring = { attrs, body ->
        String string = attrs.string
        Integer length = attrs.length?new Integer(attrs.length):50
        String end = attrs.max?:"..."
        if(string.length() > length){
            string = string.substring(0,length)+end
        }   
        out << string
    }
    
    def nl2br ={attrs, body->
        out << attrs.text?.replaceAll('\n','<br/>')
    }

    def br2nl ={attrs, body->
        out << attrs.text?.replaceAll('<br/>','\n')
    }
    
    def cleanHtml ={attrs, body->
        out << attrs.text?.replaceAll("\\<.*?\\>", "");
    }
    
    def seofy = { attrs, body ->
        def value = attrs.value.toLowerCase()
        def sustituteValues = [
            ["á","a"],
            ["é","e"],
            ["í","i"],
            ["ó","o"],
            ["ú","u"],
            ["ñ","n"],
            ["ç","c"],
            ["'",""],
            ["  ", ""]
        ]
        sustituteValues.each{ val ->
            value = value.replaceAll(val[0], val[1])
        }
        value = value.replaceAll(" ", "-")
        out << value
    }
}
