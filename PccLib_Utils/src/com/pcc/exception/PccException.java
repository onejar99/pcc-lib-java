package com.pcc.exception;

@SuppressWarnings("serial")
public class PccException extends RuntimeException
{
    public PccException()
    {
        super();
    }

    public PccException(Throwable cause)
    {
        super( cause );
    }

    public PccException(String message)
    {
        super( message );
    }

    public PccException(String message, Throwable cause)
    {
        super( message, cause );
    }
}
