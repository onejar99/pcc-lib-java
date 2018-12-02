package com.pcc.utils.reflection.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.pcc.testMaterial.TestBean;
import com.pcc.utils.reflection.ReflectionUtil;

public class ReflectionUtilTester {
	private static Log logger = LogFactory.getLog(ReflectionUtilTester.class);
	
	@Test
    public void reflectionUtil_try()
    {
        TestBean obj = new TestBean();
        obj.setAge( 18 );
        obj.setIsVip( true );
        obj.setName( "John" );
        logger.info( ReflectionUtil.getBeanFieldInfo( obj ) );

        ReflectionUtil.invokeSetter( obj, "name", "Rubio" );
        ReflectionUtil.invokeSetter( obj, "age", 108 );
        ReflectionUtil.invokeSetter( obj, "isVip", null );
        logger.info( ReflectionUtil.getBeanFieldInfo( obj ) );
    }
	
	@Test
	public void reflectionUtil_try02()
    {
        TestBean obj = new TestBean();
        obj.setAge( 18 );
        obj.setIsVip( true );
        obj.setName( "John" );

        logger.info( ReflectionUtil.invokeGetter( obj, "name" ) );
    }
}
