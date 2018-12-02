package com.pcc.utils.reflection.enums;

public enum MethodPrefixEnum
{
    SET("set"),
    GET("get");

    private String value;

    MethodPrefixEnum(String value)
    {
        this.value = value;
    }
    
    public String getValue(){
        return this.value;
    }
}
