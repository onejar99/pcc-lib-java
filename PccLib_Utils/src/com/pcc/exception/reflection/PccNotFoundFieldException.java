package com.pcc.exception.reflection;

import com.pcc.exception.PccException;

@SuppressWarnings("serial")
public class PccNotFoundFieldException extends PccException{

	public PccNotFoundFieldException(Throwable e, String fieldName, Class<?> clazz)
    {
        super( String.format( "Exception for getting field type of [%s].[%s]", clazz.getName(), fieldName ), e );
    }
}
