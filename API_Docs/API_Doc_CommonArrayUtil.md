# CommonArrayUtil



## Method Summary

### public

| Returned Type | Method                                   | Description           |
| ------------- | ---------------------------------------- | --------------------- |
| String        | concatAsString(Object[] objects)         | 將陣列的值串接成字串 (使用預設串接符號) |
| String        | concatAsString(Object[] objects, String delimiter) | 將陣列的值串接成字串 (使用指定串接符號) |





## Remark

Join array 的 API 在 Java 8 已有提供：`String.join(delimiter, elements)`

> Reference: [A quick and easy way to join array elements with a separator (the opposite of split) in Java - Stack Overflow](https://stackoverflow.com/questions/1978933/a-quick-and-easy-way-to-join-array-elements-with-a-separator-the-opposite-of-sp)



有三種使用方式：

1) directly specifying the elements

```java
String joined1 = String.join(",", "a", "b", "c");
```

2) using arrays

```java
String[] array = new String[] { "a", "b", "c" };
String joined2 = String.join(",", array);
```

3) using iterables

```java
List<String> list = Arrays.asList(array);
String joined3 = String.join(",", list);
```



或也可使用 **Apache Commons Lang** 的 `StringUtils.join`

```java
import org.apache.commons.lang3.StringUtils;
String result = StringUtils.join(list, ", ");
```





