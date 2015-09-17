class: center, middle, inverse

#Java8与函数式编程思维

## Berk
## 9/18/2015

---


## Jdk 8 语言新特性

- Lambda表达式与Functional接口



>为了克服函数式接口的这种脆弱性并且能够明确声明接口作为函数式接口的意图，Java 8增加了一种特殊的注解@FunctionalInterface（Java 8中所有类库的已有接口都添加了@FunctionalInterface注解）

- 接口的默认方法与静态方法


- 方法引用
  - 构造器引用 （Class< T >::new）
  - 静态方法引用 （Class::static_method）
  - 特定类的任意对象的方法引用（Class::method）
  - 特定对象的方法引用（instance::method）

- 注解功能扩展
  - 重复注解：通过@Repeatable注解目标注解，目标注解可以重复注解；
  - 扩展注解的支持：任何东西添加注解：局部变量、泛型类、父类与接口的实现，就连方法的异常也能添加注解。

- 更好的类型推测机制

---

## Jdk 8类库的新特新

### Optional

### Stream API

### Date/Time API

- 不变性：新的日期/时间API中，所有的类都是不可变的，这对多线程环境有好处。

- 关注点分离：新的API将人可读的日期时间和机器时间（unix timestamp）明确分离，它为日期（Date）、时间（Time）、日期时间（DateTime）、时间戳（unix timestamp）以及时区定义了不同的类。

- 清晰：在所有的类中，方法都被明确定义用以完成相同的行为。举个例子，要拿到当前实例我们可以使用now()方法，在所有的类中都定义了format()和parse()方法，而不是像以前那样专门有一个独立的类。为了更好的处理问题，所有的类都使用了工厂模式和策略模式，一旦你使用了其中某个类的方法，与其他类协同工作并不困难。

- 实用操作：所有新的日期/时间API类都实现了一系列方法用以完成通用的任务，如：加、减、格式化、解析、从日期/时间中提取单独部分，等等。

- 可扩展性：新的日期/时间API是工作在ISO-8601日历系统上的，但我们也可以将其应用在非IOS的日历上。


>> http://www.codeceo.com/article/java-8-date-time-api.html

### JavaScript引擎Nashorn

### 其它
Files 
Base64



---

## Java8中的函数编程思维

---

## Reference

[1] [Java8新特性](http://www.importnew.com/11908.html#NewFeatureOfLanguage)

[2] [What's New in JDK 8](http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html)

[3] [Java 8 日期/时间（Date Time）API指南](http://www.codeceo.com/article/java-8-date-time-api.html)

http://www.javacodegeeks.com/2014/04/java-8-date-time-api-tutorial-localdatetime.html