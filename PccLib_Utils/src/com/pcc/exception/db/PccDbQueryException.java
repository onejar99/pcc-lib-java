package com.pcc.exception.db;

import com.pcc.exception.PccException;

@SuppressWarnings("serial")
public class PccDbQueryException extends PccException{

	public PccDbQueryException(Throwable e)
    {
        super( e );
    }
}
