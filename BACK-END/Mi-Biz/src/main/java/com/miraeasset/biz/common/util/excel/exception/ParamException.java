package com.miraeasset.biz.common.util.excel.exception;

public class ParamException extends RuntimeException
{

	private static final long serialVersionUID = 1L;
	static final int NOTNUMBER = 0;
    static final int NULLVALUE = 1;
    int type;
    
    public ParamException()
    {
    }

    public ParamException(String message)
    {
        super(message);
    }

    public ParamException(String message, int type)
    {
        super(message);
        this.type = type;
    }

    public int getType()
    {
        return type;
    }
    
}
