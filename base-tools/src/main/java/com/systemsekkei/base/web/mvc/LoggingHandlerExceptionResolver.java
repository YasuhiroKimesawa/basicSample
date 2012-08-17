package com.systemsekkei.base.web.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class LoggingHandlerExceptionResolver implements HandlerExceptionResolver, Ordered
{
    private static final Log LOG
            = LogFactory.getLog( LoggingHandlerExceptionResolver.class );

    @Override
    public ModelAndView resolveException(
            HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception exception )
    {
        LOG.error( "Exception is threw by " + handler , exception );
        return null;
    }

    private int order = Ordered.LOWEST_PRECEDENCE;

    public void setOrder(int order)
    {
        this.order = order;
    }

    @Override
    public int getOrder()
    {
        return order;
    }

}
