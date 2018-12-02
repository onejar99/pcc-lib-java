package com.pcc.utils.common.test;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.pcc.utils.common.CommonArrayUtil;
import com.pcc.utils.reflection.ReflectionUtil;

public class CommonArrayUtilTester {
	private static Log logger = LogFactory.getLog(ReflectionUtil.class);
	
	@Test
    public void concatAsString_defulat_try()
    {
        Integer[] strs = new Integer[] { 1, 2, 3, 4, 5 };
        logger.info("[" + CommonArrayUtil.concatAsString( strs ) + "]");
    }

    @Test
    public void concatAsString_defulat_assert01()
    {
        Integer[] strs = new Integer[] { 1, 2, 3, 4, 5 };
        String ret = CommonArrayUtil.concatAsString( strs );
        assertEquals( ret, "1,2,3,4,5" );
    }
    
    @Test
    public void concatAsString_delimiter_assert01()
    {
        Integer[] strs = new Integer[] { 1, 2, 3, 4, 5 };
        String ret = CommonArrayUtil.concatAsString( strs, "-" );
        assertEquals( ret, "1-2-3-4-5" );
    }
}
