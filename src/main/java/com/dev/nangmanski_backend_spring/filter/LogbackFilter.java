package com.dev.nangmanski_backend_spring.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class LogbackFilter extends Filter<ILoggingEvent>{
	
    @Override
    public FilterReply decide(ILoggingEvent event) {    
        if (event.getMessage().contains("DELETE FROM SPRING_SESSION WHERE EXPIRY_TIME") || event.getMessage().contains("SESSION_ID")) {
            return FilterReply.DENY;
        }else if (event.getMessage().contains("org.springframework.security.web.csrf")) {
            return FilterReply.DENY;
        }else if (event.getMessage().contains("ResultSet.")) {
            return FilterReply.DENY;
        }else if (event.getMessage().contains("PreparedStatement.")) {
            return FilterReply.DENY;
        }else if (event.getMessage().contains("Executing prepared")) {
            return FilterReply.DENY;
        }else if (event.getMessage().contains("Completed 200")) {
            return FilterReply.DENY;
        }else if (event.getMessage().contains("GET \"/css")) {
            return FilterReply.DENY;
        }else if (event.getMessage().contains("GET \"/js")) {
            return FilterReply.DENY;
        }else if (event.getMessage().contains("GET \"/image")) {
            return FilterReply.DENY;
        }else if (event.getMessage().contains("Mapped to ResourceHttpRequestHandler")) {
            return FilterReply.DENY;
        }else if (event.getMessage().contains("Preparing: ")) {
            return FilterReply.DENY;
        }else if (event.getMessage().contains("Connection.")) {
            return FilterReply.DENY;
        }else if (event.getMessage().contains("Connection closed.")) {
            return FilterReply.DENY;
        }else if (event.getMessage().contains("Connection opened.")) {
            return FilterReply.DENY;
        }else{
            return FilterReply.ACCEPT;
        }
    }
}