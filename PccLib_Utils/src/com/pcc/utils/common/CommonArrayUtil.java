package com.pcc.utils.common;

public class CommonArrayUtil
{
    public static final String DEFAULT_CONCAT_DELIMITER = ",";

    private CommonArrayUtil(){}
    
    /**
     * 將陣列的值串接成字串 (使用預設串接符號)
     * 
     * @param objects
     * @return
     */
    public static String concatAsString(Object[] objects)
    {
        return concatAsString( objects, DEFAULT_CONCAT_DELIMITER );
    }

    /**
     * 將陣列的值串接成字串 (使用指定串接符號)
     * 
     * @param objects
     * @param delimiter
     * @return
     */
    public static String concatAsString(Object[] objects, String delimiter)
    {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objects)
        {
            sb.append( obj.toString() );
            sb.append( delimiter );
        }
        if (objects.length > 0)
            sb.delete( sb.length() - delimiter.length(), sb.length() );
        return sb.toString();
    }
}
