package com.pilgrim_lifestyle.web.tool;

import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;

@Component( "onetimeToken" )
public class OnetimeToken
{
    private static final String TOKEN = "token";

    private static final String REQUEST_TOKEN = "requestToken";

    public void initializeToken( WebRequest request, Model model )
    {
       String token = generateToken( request );

       request.setAttribute( TOKEN, token, WebRequest.SCOPE_SESSION );

       model.addAttribute( REQUEST_TOKEN, token );
    }

    public boolean checkToken( WebRequest request ) throws BadTokenException
    {
        String sessionToken = (String)request.getAttribute( TOKEN, WebRequest.SCOPE_SESSION );

        String parameterToken = (String)request.getParameter( REQUEST_TOKEN );

        this.removeToken( request );

        if( isEmpty( parameterToken ) ) throw new BadTokenException( "token error" );

        if( isEmpty( sessionToken ) ) throw new BadTokenException( "token error" );

        if( ! parameterToken.equals( sessionToken )  ) throw new BadTokenException( "token error" );

        return true;
    }

    public void removeToken( WebRequest request )
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
