package com.pcc.exception.db;

import com.pcc.exception.PccException;

@SuppressWarnings("serial")
public class PccDbConnectionException extends PccException{

	public PccDbConnectionException(Throwable e)
    {
        super( "Exception for getting connection", e );
    }
}
