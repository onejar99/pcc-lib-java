# ReflectionUtil



## Method Summary

### public

| Returned Type | Method                                   | Description                             |
| ------------- | ---------------------------------------- | --------------------------------------- |
| String[]      | convertFieldArrayToNameArray(Field[] fieldArray) | 將欄位 Array 轉換成欄位名稱 Array                 |
| List<String>  | convertFieldListToNameList(List<Field> fieldList) | 將欄位 List 轉換成欄位名稱 List                   |
| List<Field>   | getAllFieldList(Object obj)              | 取得指定物件的所有欄位屬性清單(包含父類別)                  |
| List<Field>   | getAllFieldList(Class<?> objClazz)       | 取得指定類別的所有欄位屬性清單(包含父類別)                  |
| List<String>  | getAllFieldNameList(Object obj)          | 取得指定物件的所有欄位名稱(包含父類別)                    |
| List<String>  | getAllFieldNameList(Class<?> objClazz)   | 取得指定類別的所有欄位名稱(包含父類別)                    |
| String        | getBeanFieldInfo(Object bean)            | 取得 Bean 所有的 field 名稱和值 (debugging tool) |
| List<Field>   | getFieldListAnnotation(T bean, Class<A> annoClazz) | 取得某物件裡，有指定 Annotation 的欄位名稱陣列           |
| List<Field>   | getFieldListAnnotation(Class<T> objClazz, Class<A> annoClazz) | 取得某類別裡，有指定 Annotation 的欄位名稱陣列           |
| Class<?>      | getGenericClassByIndex(Object obj, int index) | 取得繼承的泛型類別                               |
| Object        | invokeGetter(Object bean, String fieldName) | 呼叫 Bean 的指定 getter                      |
| void          | invokeSetter(Object bean, String fieldName, Object value) | 呼叫 Bean 的指定 setter                      |



### private

| Returned Type | Method                                   | Description              |
| ------------- | ---------------------------------------- | ------------------------ |
| Class<?>      | getFieldType(Class<?> pojoClazz, String fieldName) | 取得指定 filed 的資料型態類別       |
| Method        | getMethodObject(Class<?> clazz, String methodName, Class<?>... fieldTypeClazzArray) | 取得指定類別的函式物件              |
| String        | getPropertyMethodName(MethodPrefixEnum prefix, String fieldName) | 組裝指定 property 與特定前綴的函式名稱 |
| Object        | invokeMethod(Object obj, Method method, Object... args) | 呼叫指定物件的函式 by 函式物件        |

