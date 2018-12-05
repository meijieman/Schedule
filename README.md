### Thymeleaf 常用属性

#### th:action

#### th:each

#### th:field

#### th:href

#### th:id

#### th:if

#### th:include

#### th:fragment

#### th:object

#### th:src

#### th:replace

#### th:text

#### th:value






### thymeleaf 基本表达式
* ${}  
变量表达式（美元表达式）
用于访问容器上下文环境中的变量

* *{}  
选择表达式（星号表达式）
选择表达式计算的是选定的对象，而不是整个环境变量映射。也就是：只要是没有选择的对象，选择表达式与变量表达式的语法是完全一样的。那什么是选择的对象呢？是一个：`th:object`对象属性绑定的对象。

* \#{}  
消息表达式（井号表达式，资源表达式）
通常与`th:text`属性一起使用，指明声明了`th:text`的标签的文本是#{}中的key所对应的value，而标签内的文本将不会显示。

* @{}  
超链接url表达式

* \#maps  
工具对象表达式。
常用于日期、集合、数组对象的访问。这些工具对象就像是java对象，可以访问对应java对象的方法来进行各种操作。


其他工具对象表达式还有
```
#dates
#calendars
#numbers 
#strings
#objects
#bools
#arrays
#lists
#sets
```













### 参考资料
* https://www.cnblogs.com/hjwublog/p/5051732.html#_label0
* http://www.cnblogs.com/hjwublog/p/5051632.html#_label0




