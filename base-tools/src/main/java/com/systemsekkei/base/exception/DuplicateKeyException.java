package com.systemsekkei.base.exception;

public class DuplicateKeyException extends Exception
{
    public DuplicateKeyException()
    {
    }

    public DuplicateKeyException( String message, Throwable cause )
    {
        super( message, cause );
    }

    public DuplicateKeyException( String message )
    {
        super( message );
    }

    public DuplicateKeyException( Throwable cause )
    {
        super( cause );
    }

    private static final long serialVersionUID = 7061663015510715037L;
}
