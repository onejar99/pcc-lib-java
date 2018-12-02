package com.pcc.exception.reflection;

import java.lang.reflect.Method;

import com.pcc.exception.PccException;
import com.pcc.utils.common.CommonArrayUtil;

@SuppressWarnings("serial")
public class PccInvokeMethodException extends PccException{

	public PccInvokeMethodException(Throwable e, Object obj, Method method, Object[] params)
    {
        super( String.format( "Exception for invoking method [%s].[%s] with args={%s}",
                obj.getClass().getName(), method.getName(), CommonArrayUtil.concatAsString( params ) ), e );
    }
}

