package com.pcc.utils.json.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.pcc.testMaterial.TestJsonBean;
import com.pcc.utils.json.JsonUtil;
import com.pcc.utils.reflection.ReflectionUtil;

public class JsonUtilTester
{
    private static Logger logger = LogManager.getLogger( JsonUtilTester.class );

    @Test
    public void convertObjToString_try()
    {
    	TestJsonBean obj = generateTestBeanStub();
        String rlt = JsonUtil.convertObjToString( obj );
        logger.info( String.format( "Obj to JSON: [%s]", rlt ) );
    }

    @Test
    public void convertStringToObj_try()
    {
    	TestJsonBean obj = generateTestBeanStub();
        String jsonStr = JsonUtil.convertObjToString( obj );
    	Class<?> objClazz = TestJsonBean.class;
        Object rlt = JsonUtil.convertStringToObj( jsonStr, objClazz );
        logger.info( String.format( "JSON to Obj: [%s]", ReflectionUtil.getBeanFieldInfo(rlt) ) );
    }
    
    @Test
    public void convertObjToString_assert01()
    {
    	String jsonStr = "{\"pid\":\"A123456789\",\"name\":\"John\",\"age\":18,\"isVip\":true,\"address\":\"Mars 11\",\"birthday\":\"20000101\",\"itemList\":[\"Apple\",\"Banana\"],\"skillAry\":[\"Run\",\"Jump\"],\"applyDate\":1128873600000}";
    	TestJsonBean obj = generateTestBeanStub();
        String rlt = JsonUtil.convertObjToString( obj );
        assertEquals( rlt, jsonStr );
    }
    
    public static TestJsonBean generateTestBeanStub(){
    	List<String> itemList = new ArrayList<>();
        itemList.add( "Apple" );
        itemList.add( "Banana" );
        String[] skillAry = { "Run", "Jump" };

        TestJsonBean obj = new TestJsonBean();
        obj.setAddress( "Mars 11" );
        obj.setAge( 18 );
        obj.setBirthday( localDate2Date(LocalDate.of(2000, 1, 1)) );
        obj.setIsVip( true );
        obj.setItemList( itemList );
        obj.setName( "John" );
        obj.setPid( "A123456789" );
        obj.setSkillAry( skillAry );
        obj.setApplyDate( localDate2Date(LocalDate.of(2005, 10, 10)) );
        return obj;
    }
    
    public static Date localDate2Date(LocalDate localDate){
    	return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
