package com.pilgrim_lifestyle.web.tool;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="bad token")
public class BadTokenException extends Exception
{
    public BadTokenException( String message, Throwable cause )
    {
        super( message, cause );
    }

    public BadTokenException( String cause )
    {
        super( cause );
    }

    public BadTokenException( Throwable cause )
    {
        super( cause );
    }

    private static final long serialVersionUID = -223794548910340717L;

}
