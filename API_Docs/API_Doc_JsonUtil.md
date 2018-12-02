# JsonUtil



## Method Summary

### public

| Returned Type | Method                                   | Description   |
| ------------- | ---------------------------------------- | ------------- |
| String        | convertObjToString(Object obj)           | 物件轉 JSON      |
| Object        | convertStringToObj(String jsonStr, Class<?> objClazz) | JSON 轉指定類別的物件 |



### private

| Returned Type | Method      | Description         |
| ------------- | ----------- | ------------------- |
| void          | checkInit() | 檢查暨初始化 ObjectMapper |
| void          | init()      | 初始化 ObjectMapper    |