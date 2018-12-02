# PCC Java Libraries

My Java utility libraries.



## Library Summary

* Logger: Log4j (delegated by apache commons-logging)
* Unit test: JUnit

| Library          | Description                              |
| ---------------- | ---------------------------------------- |
| PccLib_Utils     | Various utility APIs.                    |
| PccLib_Practices | Some small scale practices.              |
| PccLib_Parent    | Used to be a parent of other projects for sharing packages. |



## PccLib_Utils

### Major Package Summary

| Package              | Description         |
| -------------------- | ------------------- |
| com.pcc.utils        | 各式 Utility          |
| com.pcc.exception    | 自定義例外               |
| com.pcc.testMaterial | Unit Test 所需素材類別集中處 |

### Utility List

| Utility Name                             | API Docs                                 | Remark                                   |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| [ReflectionUtil](./PccLib_Utils/src/com/pcc/utils/reflection) | [APIs](./API_Docs/API_Doc_ReflectionUtil.md) | 包含使用範例：取得類別泛型參數的類別繼承 & 取得類別宣告屬性(含繼承自父類別) |
| [CommonArrayUtil](./PccLib_Utils/src/com/pcc/utils/common) | [APIs](./API_Docs/API_Doc_CommonArrayUtil.md) |                                          |
| [CommonListUtil](./PccLib_Utils/src/com/pcc/utils/common) | [APIs](./API_Docs/API_Doc_CommonListUtil.md) |                                          |
| [JsonUtil](./PccLib_Utils/src/com/pcc/utils/json) | [APIs](./API_Docs/API_Doc_JsonUtil.md)   | 使用  `com.fasterxml.jackson`              |



## PccLib_Practices

### HibernateAnnoLikeJdbc

* Description
  * 利用 Annotaion 和 Reflection，在原生 JDBC 實現類似 Hibernate ORM 注入值到 Java 物件效果的實作練習。
  * 使用自定義的 `@PccColumn` 和 `DatatypeEnum` 實現類似 `@Column` 效果。
  * DAO 層低耦合設計。
* package
  * [com.pcc.hibernateAnnoLikeJdbc](./PccLib_Practices/src/com/pcc/hibernateAnnoLikeJdbc)
