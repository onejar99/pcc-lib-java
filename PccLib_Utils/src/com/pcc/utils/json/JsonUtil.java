package com.pcc.utils.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pcc.exception.PccException;

public class JsonUtil
{
    private static ObjectMapper objectMapper = null;

    private JsonUtil(){}
    
    /**
     * 初始化 ObjectMapper
     */
    private static void init()
    {
        objectMapper = new ObjectMapper();
    }

    /**
     * 檢查暨初始化 ObjectMapper
     */
    private static void checkInit()
    {
        if (objectMapper == null) init();
    }

    /**
     * 物件轉 JSON
     * 
     * @param obj
     * @return
     */
    public static String convertObjToString(Object obj)
    {
        String rlt = null;
        checkInit();
        try
        {
            rlt = objectMapper.writeValueAsString( obj );
        }
        catch (JsonProcessingException e)
        {
            throw new PccException( "Exception for JSON generating", e );
        }
        return rlt;
    }

    /**
     * JSON 轉指定類別的物件
     * 
     * @param jsonStr
     * @param objClazz
     * @return
     */
    public static Object convertStringToObj(String jsonStr, Class<?> objClazz)
    {
        Object rlt = null;
        checkInit();
        try
        {
            rlt = objectMapper.readValue( jsonStr, objClazz );
        }
        catch (IOException e)
        {
            throw new PccException( "Exception for JSON parsing", e );
        }
        return rlt;
    }
}
