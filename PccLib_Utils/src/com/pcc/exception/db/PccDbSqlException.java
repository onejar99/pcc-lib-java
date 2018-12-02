package com.pcc.exception.db;

import com.pcc.exception.PccException;

@SuppressWarnings("serial")
public class PccDbSqlException extends PccException{

	public PccDbSqlException(Throwable e)
    {
        super( e );
    }
}
