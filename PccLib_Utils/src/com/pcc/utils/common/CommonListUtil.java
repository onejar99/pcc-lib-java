package com.pcc.utils.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonListUtil {

	public static final String DEFAULT_CONCAT_DELIMITER = ",";
	
	private CommonListUtil(){}
	
	/**
	 * 將 List 的值串接成字串 (使用預設串接符號)
	 * 
	 * @param list
	 * @return
	 */
	public static <T> String concatAsString(List<T> list)
    {
        return concatAsString( list, DEFAULT_CONCAT_DELIMITER );
    }

	/**
	 * 將 List 的值串接成字串 (使用指定串接符號)
	 * 
	 * @param list
	 * @param delimiter
	 * @return
	 */
    public static <T> String concatAsString(List<T> list, String delimiter)
    {
        StringBuilder sb = new StringBuilder();
        for (T obj : list)
        {
            sb.append( obj.toString() );
            sb.append( delimiter );
        }
        if (!list.isEmpty())
            sb.delete( sb.length() - delimiter.length(), sb.length() );
        return sb.toString();
    }
    
    /**
     * 清除重複的值 (破壞原本順序)
     * Notice: It'll destroys the ordering of the elements in the List.
     * 
     * @param list
     */
	public static <T> void removeDuplicatedElementsWithoutOrdered(List<T> list) {
		Set<T> hs = new HashSet<>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
	}
	
	/**
     * 清除重複的值 (保留原本順序)
     * 
     * @param list
     */
	public static <T> List<T> removeDuplicatedElements(List<T> list) {
		List<T> ret = new ArrayList<>();
		for(T obj: list) {
			if(!ret.contains(obj)) ret.add(obj);
		}
		return ret;
	}
}
