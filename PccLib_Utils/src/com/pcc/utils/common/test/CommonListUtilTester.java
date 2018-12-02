package com.pcc.utils.common.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import com.pcc.utils.common.CommonListUtil;

public class CommonListUtilTester {

	private static Log logger = LogFactory.getLog(CommonListUtilTester.class);
	
	@Test
    public void concatAsString_defulat_assert01()
    {
		List<String> list = generateListStub();
        String ret = CommonListUtil.concatAsString( list );
        assertEquals( ret, "Apple,Banana,Apple,Cake" );
    }
	
	@Test
    public void concatAsString_delimiter_assert01()
    {
		List<String> list = generateListStub();
        String ret = CommonListUtil.concatAsString( list, "-*-" );
        assertEquals( ret, "Apple-*-Banana-*-Apple-*-Cake" );
    }
    
	@Test
    public void removeDuplicatedElementsWithoutOrdered_assert01()
    {
        List<String> list = generateListStub();
        logger.info(String.format("Before: %s", list.toString()));
        
        CommonListUtil.removeDuplicatedElementsWithoutOrdered(list);
        String ret = list.toString();
        logger.info(String.format("After: %s", ret));
        assertEquals( ret, "[Apple, Cake, Banana]" );
    }
	
	@Test
    public void removeDuplicatedElements_assert01()
    {
        List<String> list = generateListStub();
        logger.info(String.format("Before: %s", list.toString()));
        
        list = CommonListUtil.removeDuplicatedElements(list);
        String ret = list.toString();
        logger.info(String.format("After: %s", ret));
        assertEquals( ret, "[Apple, Banana, Cake]" );
    }
	
	public static List<String> generateListStub(){
		List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apple");
        list.add("Cake");
        return list;
	}
}
