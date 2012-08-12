package com.pilgrim_lifestyle.web;

import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;

@Component( "webBase" )
public class WebBase
{
    private static final String TOKEN = "token";

    private static final String REQUEST_TOKEN = "requestToken";

    public void initializeToken( WebRequest request, Model model )
    {
       String token = generateToken( request );

       request.setAttribute( TOKEN, token, WebRequest.SCOPE_SESSION );

       model.addAttribute( REQUEST_TOKEN, token );
    }

    public boolean checkToken( WebRequest request )
    {
        String sessionToken = (String)request.getAttribute( TOKEN, WebRequest.SCOPE_SESSION );

        String parameterToken = (String)request.getParameter( REQUEST_TOKEN );

        if( !isEmpty( parameterToken ) && !isEmpty( sessionToken ) && parameterToken.equals( sessionToken )  )
        {
            return true;
        }

        return false;
    }

    public void removeToken( WebRequest request, Model model )
    {
        request.removeAttribute( TOKEN, WebRequest.SCOPE_SESSION );
    }

    private String generateToken( WebRequest request )
    {
        long seed = System.currentTimeMillis();

        Random random = new Random();

        random.setSeed( seed );

        return Long.toString( seed ) + Long.toString( Math.abs( random.nextLong() ) );
    }

    private boolean isEmpty( String val )
    {
        if( val == null || val.isEmpty() )
        {
            return true;
        }
        return false;
    }
}
