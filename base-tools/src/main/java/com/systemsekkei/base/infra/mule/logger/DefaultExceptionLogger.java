package com.systemsekkei.base.infra.mule.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.api.ExceptionPayload;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.message.ExceptionMessage;
import org.mule.util.StringUtils;
import org.mule.util.SystemUtils;


public class DefaultExceptionLogger implements Callable
{
    private static final Log LOG = LogFactory.getLog( DefaultExceptionLogger.class );

    private static final String LOGGING_MESSAGE_TEMPLATE =
            SystemUtils.LINE_SEPARATOR
          + StringUtils.repeat( '*', 80 ) + SystemUtils.LINE_SEPARATOR
          + "%s" + SystemUtils.LINE_SEPARATOR
          + StringUtils.repeat( '-', 80 ) + SystemUtils.LINE_SEPARATOR
          + "Stack trace:" + SystemUtils.LINE_SEPARATOR
          + StringUtils.repeat( '-', 80 ) + SystemUtils.LINE_SEPARATOR
          + "%s" + SystemUtils.LINE_SEPARATOR
          + StringUtils.repeat( '-', 80 ) + SystemUtils.LINE_SEPARATOR
          + "Payload:" + SystemUtils.LINE_SEPARATOR
          + StringUtils.repeat( '-', 80 ) + SystemUtils.LINE_SEPARATOR
          + "%s" + SystemUtils.LINE_SEPARATOR
          + StringUtils.repeat( '-', 80 ) + SystemUtils.LINE_SEPARATOR
          + "Mule Message:" + SystemUtils.LINE_SEPARATOR
          + StringUtils.repeat( '-', 80 ) + SystemUtils.LINE_SEPARATOR
          + "%s" + SystemUtils.LINE_SEPARATOR
          + StringUtils.repeat( '*', 80 ) + SystemUtils.LINE_SEPARATOR;

    @Override
    public final Object onCall( MuleEventContext eventContext ) throws Exception
    {
        MuleMessage muleMessage = eventContext.getMessage();
        String loggingMessage = getLoggingMessage( muleMessage );

        Log logger = getLog();
        logger.error(loggingMessage);

        return muleMessage;
    }

    protected Log getLog()
    {
        return LOG;
    }

    protected String getLoggingMessage(MuleMessage muleMessage)
    {
        String loggingMessageHeader = getLoggingMessageHeader( muleMessage );
        String exceptionStackTrace = getExceptionStackTrace( muleMessage );
        Object payload = getPayload( muleMessage );

        return String.format( LOGGING_MESSAGE_TEMPLATE,
                loggingMessageHeader, exceptionStackTrace, payload, muleMessage );
    }

    private static final String DEFAULT_MESSAGE_HEADER = "Exception is threw.";

    private String loggingMessageHeader = DEFAULT_MESSAGE_HEADER;

    protected String getLoggingMessageHeader(MuleMessage muleMessage)
    {
        return loggingMessageHeader;
    }

    protected static final String getExceptionStackTrace(MuleMessage message)
    {
        Throwable exception = getException( message );
        if (exception == null)
        {
            return "*** No exception stack trace ***"; 
        }

        Writer writer = new StringWriter();
        exception.printStackTrace( new PrintWriter( writer ) );

        return writer.toString();
    }

    protected static final Throwable getException(MuleMessage message)
    {
        ExceptionPayload exceptionPayload = message.getExceptionPayload();
        if (exceptionPayload == null)
        {
            return null;
        }
        return exceptionPayload.getException();
    }

    protected static final Object getPayload(MuleMessage message)
    {
        Object payload = message.getPayload();
        if (payload instanceof ExceptionMessage)
        {
            ExceptionMessage exceptionMessage = (ExceptionMessage) payload;
            payload = exceptionMessage.getPayload();
        }

        return payload;
    }

    public void setLoggingMessageHeader(String loggingMessageHeader)
    {
        this.loggingMessageHeader = loggingMessageHeader;
    }
}
