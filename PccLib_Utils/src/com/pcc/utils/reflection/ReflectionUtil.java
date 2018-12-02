package com.pcc.utils.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pcc.exception.PccException;
import com.pcc.exception.reflection.PccInvokeMethodException;
import com.pcc.exception.reflection.PccNotFoundFieldException;
import com.pcc.exception.reflection.PccNotFoundMethodException;
import com.pcc.utils.common.CommonListUtil;
import com.pcc.utils.reflection.enums.MethodPrefixEnum;

public class ReflectionUtil {
	private ReflectionUtil() {
	}

	/**
	 * 呼叫 Bean 的指定 getter
	 * 
	 * @param bean
	 * @param fieldName
	 * @return
	 */
	public static Object invokeGetter(Object bean, String fieldName) {
		Class<?> clazz = bean.getClass();
		String methodName = getPropertyMethodName(MethodPrefixEnum.GET, fieldName);
		Method method = getMethodObject(clazz, methodName);
		return invokeMethod(bean, method);
	}

	/**
	 * 呼叫 Bean 的指定 setter
	 * 
	 * @param bean
	 * @param fieldName
	 * @param value
	 */
	public static void invokeSetter(Object bean, String fieldName, Object value) {
		Class<?> clazz = bean.getClass();
		String methodName = getPropertyMethodName(MethodPrefixEnum.SET, fieldName);
		Method method = getMethodObject(clazz, methodName, getFieldType(bean.getClass(), fieldName));
		invokeMethod(bean, method, value);
	}

	/**
	 * 組裝指定 property 與特定前綴的函式名稱
	 * 
	 * @param prefix
	 * @param fieldName
	 * @return
	 */
	private static String getPropertyMethodName(MethodPrefixEnum prefix, String fieldName) {
		StringBuilder sb = new StringBuilder();
		sb.append(prefix.getValue());
		sb.append(fieldName.toUpperCase().charAt(0));
		sb.append(fieldName.substring(1));
		return sb.toString();
	}

	/**
	 * 取得指定類別的函式物件
	 * 
	 * @param clazz
	 * @param methodName
	 * @param fieldTypeClazzArray
	 * @return
	 */
	private static Method getMethodObject(Class<?> clazz, String methodName, Class<?>... fieldTypeClazzArray) {
		Method method;
		try {
			method = clazz.getDeclaredMethod(methodName, fieldTypeClazzArray);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new PccNotFoundMethodException(e, methodName, clazz);
		}
		return method;
	}

	/**
	 * 呼叫指定物件的函式 by 函式物件
	 * 
	 * @param method
	 * @param obj
	 * @param args
	 * @return
	 */
	private static Object invokeMethod(Object obj, Method method, Object... args) {
		Object val = null;
		try {
			val = method.invoke(obj, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new PccInvokeMethodException(e, obj, method, args);
		}

		return val;
	}

	/**
	 * 取得指定 filed 的資料型態類別
	 * 
	 * @param pojoClazz
	 * @param fieldName
	 * @return
	 */
	private static Class<?> getFieldType(Class<?> pojoClazz, String fieldName) {
		Field f;
		try {
			f = pojoClazz.getDeclaredField(fieldName);
			return f.getType();
		} catch (NoSuchFieldException | SecurityException e) {
			throw new PccNotFoundFieldException(e, fieldName, pojoClazz);
		}
	}

	/**
	 * 取得某物件裡，有指定 Annotation 的欄位名稱陣列
	 * 
	 * @param bean
	 * @param clazz
	 * @return
	 */
	public static <A extends Annotation, T> List<Field> getFieldListAnnotation(T bean, Class<A> annoClazz) {
		return getFieldListAnnotation(bean.getClass(), annoClazz);
	}

	/**
	 * 取得某類別裡，有指定 Annotation 的欄位名稱陣列
	 * 
	 * @param objClazz
	 * @param annoClazz
	 * @return
	 */
	public static <A extends Annotation, T> List<Field> getFieldListAnnotation(Class<T> objClazz, Class<A> annoClazz) {
		List<Field> rltList = new ArrayList<>();
		Field[] fieldAry = objClazz.getDeclaredFields();
		for (Field f : fieldAry) {
			A anno = f.getDeclaredAnnotation(annoClazz);
			if (anno != null)
				rltList.add(f);
		}
		return rltList;
	}

	/**
	 * 將欄位 List 轉換成欄位名稱 List
	 * 
	 * @param fieldList
	 * @return
	 */
	public static List<String> convertFieldListToNameList(List<Field> fieldList) {
		List<String> rlt = new ArrayList<>();
		for (Field f : fieldList)
			rlt.add(f.getName());
		return rlt;
	}

	/**
	 * 將欄位 Array 轉換成欄位名稱 Array
	 * 
	 * @param fieldArray
	 * @return
	 */
	public static String[] convertFieldArrayToNameArray(Field[] fieldArray) {
		String[] rlt = new String[fieldArray.length];
		for (int i = 0; i < fieldArray.length; i++)
			rlt[i] = fieldArray[i].getName();
		return rlt;
	}

	/**
	 * 取得指定物件的所有欄位屬性清單(包含父類別)
	 * 
	 * @param obj
	 * @return
	 */
	public static List<Field> getAllFieldList(Object obj) {
		return getAllFieldList(obj.getClass());
	}

	/**
	 * 取得指定類別的所有欄位屬性清單(包含父類別)
	 * 
	 * @param objClazz
	 * @return
	 */
	public static List<Field> getAllFieldList(Class<?> objClazz) {
		List<Field> rlt = new ArrayList<>();
		rlt.addAll(Arrays.asList(objClazz.getDeclaredFields()));

		Class<?> superClazz = objClazz.getSuperclass();
		if (superClazz != null)
			rlt.addAll(getAllFieldList(superClazz));

		return rlt;
	}

	/**
	 * 取得指定物件的所有欄位名稱，包含父類別 (過濾同名欄位)
	 * 
	 * @param obj
	 * @return
	 */
	public static List<String> getAllFieldNameList(Object obj) {
		return getAllFieldNameList(obj);
	}

	/**
	 * 取得指定類別的所有欄位名稱，包含父類別 (過濾同名欄位)
	 * 
	 * @param objClazz
	 * @return
	 */
	public static List<String> getAllFieldNameList(Class<?> objClazz) {
		List<String> fieldNameList = convertFieldListToNameList(getAllFieldList(objClazz));
		return CommonListUtil.removeDuplicatedElements(fieldNameList);
	}

	/**
	 * 取得繼承的泛型類別
	 * 
	 * @param obj
	 * @param index
	 * @return
	 */
	public static Class<?> getGenericClassByIndex(Object obj, int index) {
		Type genericSuperclass = obj.getClass().getGenericSuperclass();
		ParameterizedType paramType = ((ParameterizedType) genericSuperclass);
		Type[] actualTypeArguments = paramType.getActualTypeArguments();

		if (index >= actualTypeArguments.length)
			throw new PccException(
					String.format("The specified index is out of the boundary! Index=[%s] Boundary size=[%s]", index,
							actualTypeArguments.length));

		Type targetType = actualTypeArguments[index];
		return (Class<?>) targetType;
	}

	/**
	 * 取得 Bean 所有的 field 名稱和值 (debugging tool)
	 * 
	 * @param bean
	 */
	public static String getBeanFieldInfo(Object bean) {
		StringBuilder sb = new StringBuilder();
		if (bean == null) {
			sb.append("THIS BEAN IS A NULL OBJECT!");
			return sb.toString();
		}

		Class<?> clazz = bean.getClass();
		Field[] fields = clazz.getDeclaredFields();

		sb.append(String.format("====== class=[%s] =====%n", bean.getClass().getName()));
		for (Field f : fields) {
			Object val = invokeGetter(bean, f.getName());
			sb.append(String.format("Field=[%s] \tvalue=[%s]%n", f.getName(), java.util.Objects.toString(val, null)));
		}
		sb.append("--------------------\n");

		return sb.toString();
	}
}
