package com.pcc.utils.reflection.example;

import java.lang.reflect.Field;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pcc.utils.common.CommonArrayUtil;
import com.pcc.utils.common.CommonListUtil;
import com.pcc.utils.reflection.ReflectionUtil;

public class SuperSubClassFieldExample {
	
    public static void main(String[] args)
    {
    	Log logger = LogFactory.getLog(SuperSubClassFieldExample.class);
    	
        Field[] fieldAry;
        String[] nameAry;

        // 1. (Native API) 取得該類別宣告的欄位，不含繼承，無論 private/public
        fieldAry = Oppo.class.getDeclaredFields();
        nameAry = ReflectionUtil.convertFieldArrayToNameArray(fieldAry);
        logger.info( String.format("Oppo Getting Declared Fields: [%s]", CommonArrayUtil.concatAsString(nameAry)) );

        // 2. (Native API) 取得該類別擁有的欄位，含繼承，但只限 public
        fieldAry = Oppo.class.getFields();
        nameAry = ReflectionUtil.convertFieldArrayToNameArray(fieldAry);
        logger.info( String.format("Oppo Getting (Public) Fields: [%s]", CommonArrayUtil.concatAsString(nameAry)) );

        // 3. (PCC API) 取得該類別擁有的欄位名稱(排除同名)，含繼承，不限 private/public
        List<String> fieldNameList = ReflectionUtil.getAllFieldNameList(Oppo.class);
        logger.info( String.format("Oppo Getting All Fields: [%s]", CommonListUtil.concatAsString(fieldNameList)) );
    }
}

class Machine
{
    private String serialNumber;
    public String name;
}

class Phone extends Machine
{
    private String aaa;
    public String type;
}

class Oppo extends Phone
{
    private String batch;
    public String os;
    public String name;
}
