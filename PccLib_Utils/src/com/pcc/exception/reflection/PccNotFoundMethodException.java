package com.pcc.exception.reflection;

import com.pcc.exception.PccException;

@SuppressWarnings("serial")
public class PccNotFoundMethodException extends PccException{

	public PccNotFoundMethodException(Throwable e, String methodName, Class<?> clazz)
    {
        super( String.format( "Exception for not found method [%s] with [%s]", methodName, clazz.getName() ), e );
    }
}
