class: center, middle, inverse

# JDK8 中的函数式编程

### Berk
### 9/23/2015




---

class: center, middle, inverse

## JDK8 中的函数式编程


---

### Lambda 表达式


```java
//Consumer使用 @FunctionalInterface 明确声明接口作为函数式接口.
Consumer<String> consumer1 = new Consumer<String>()
{
    public void accept(final String name)
    {
        System.out.println(name);
    }
};

Consumer<String> consumer2 = (final String name) -> System.out
        .println(name);

Consumer<String> consumer3 = (name) -> System.out.println(name);

Consumer<String> consumer4 = name -> System.out.println(name);

Consumer<String> consumer5 = System.out::println;

Stream.of("hello", "world").forEach(consumer1);
Stream.of("hello", "world").forEach(consumer2);
Stream.of("hello", "world").forEach(consumer3);
Stream.of("hello", "world").forEach(consumer4);
Stream.of("hello", "world").forEach(consumer5);

```

---

### 方法引用(Method Reference)

- 构造器引用 （Class< T >::new）
- 静态方法引用 （Class::static_method）
- 特定类的任意对象的方法引用（Class::method）
- 特定对象的方法引用（instance::method）


```java

final List<Integer> words = IntStream.range('A', 'z')
        .mapToObj(Integer::new)
        .collect(Collectors.toList());

//Without method reference
BigDecimal bigDecimal = Stream.of("hello", "world", "!")
        .flatMapToInt((s) -> s.chars())
        .filter((s) -> words.contains(s))
        .mapToObj((s) -> String.valueOf(s))
        .map((s) -> new BigDecimal(s))
        .reduce(new BigDecimal(1), (x, y) -> x.add(y));

//With method reference
BigDecimal ret = Stream.of("hello", "world", "!")
        .flatMapToInt(String::chars) //Class::method
        .filter(words::contains)  //instance::method
        .mapToObj(String::valueOf) //Class::static_method
        .map(BigDecimal::new) // Class< T >::new
        .reduce(new BigDecimal(1), BigDecimal::add);
```


---

### 使用集合(1)


- 迭代(forEach)

```java
final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
//Old way.
for (String friend : friends)
{
    System.out.println(friend);
}
//New way.
friends.forEach(name -> System.out.println(name));

```

- 转换 (map)

```java
//Old way.
List<String> uppercaseNames = new ArrayList<String>();
for (String name : friends)
{
    uppercaseNames.add(name.toUpperCase());
}
System.out.println(uppercaseNames);
//New way.
uppercaseNames = friends.stream().map(String::toUpperCase)
                        .collect(Collectors.toList());
System.out.println(uppercaseNames);

```
---

### 使用集合(2)

- 筛选(filter)

```java
//Old way.
for (String name : friends){
    if (name.contains("r") && name.contains("a")) 
        System.out.println(name);    
}
//New way.
friends.stream().filter((s) -> s.contains("r"))
       .filter((s) -> s.contains("a")).forEach(System.out::println);
```

- 元素选取(findFirst/findAny)

```java
//Old way
String foundName = null;
for (String name : friends){
    if (name.startsWith("N")){
        foundName = name;
        break;
    }
}
if (foundName == null) throw new NoSuchElementException("no name found.");
System.out.println(foundName);
//New way.
friends.stream().filter((s) -> s.startsWith("N")).findFirst()
       .ifPresent(System.out::println);
```

---

### 使用集合(3)

- 聚合操作(reduce/collect)
    - 统计量(sum,average,max,min,count)

    - To Java Map

    - 分组统计（groupBy /partitioningBy）

---

### 使用集合(Stream API 小结）

- Intermediate 操作

    - 这类操作都是惰性化的（lazy）；
    - 包括 map、flatMap、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered

- Terminal 操作
    - Terminal 操作的执行，才会真正开始流的遍历，并且会生成一个结果；
    - 包括forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator

- Short-circuiting 操作
    - 对于一个 intermediate 操作，如果它接受的是一个无限大（infinite/unbounded）的 Stream，但返回一个有限的新 Stream；

    - 对于一个 terminal 操作，如果它接受的是一个无限大的 Stream，但能在有限的时间计算出结果；

    - 包括 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit。


---

### String与资源处理

- 字符串迭代.

```java
final String str = "hello world !";
//Old way, skip 6, limit 5 chars
int i = 0;
for (char c : str.toCharArray()) {
    if (i >= 6 && i < 6 + 5) {
        System.out.println(c);
    }
    i++;
}
//New way
str.chars().skip(6).limit(5).forEach((x) -> System.out.println((char) x));

```

- 文件夹迭代

- 文本处理

```java

Map<String, Long> map = Files.lines(Paths.get("./build.gradle")).flatMap(line -> line.chars()
        .mapToObj(c -> String.valueOf((char) c)))
        .collect(Collectors.groupingBy((x) -> x, TreeMap::new, Collectors.counting()));
System.out.println(map);

```



---

### 关于null

```java

Optional<UsingCollectionsDemo.Person> optional = Optional.of(new UsingCollectionsDemo.Person("aaa", 22));
optional.map(UsingCollectionsDemo.Person::getName).ifPresent(System.out::println);

Optional<UsingCollectionsDemo.Person> optional1 = Optional.of(new UsingCollectionsDemo.Person(null, 22));
System.out.println(optional1.flatMap(UsingCollectionsDemo.Person::getNameOptional).orElse("null"));

```
---

## 函数式编程基本原则

一种编程范式


- 避免可变状态

- 函数是第一类值（Functions as First-Class Values）
意味着函数可以像参数一样传输可以返回

- 支持懒惰计算（lazy evaluation）；

- 使用递归作为控制流程的机制；

- 加强了引用透明性；

- 没有副作用（Side-Effect）；


---

##JDK8其它主题略

### 注解功能扩展
- 重复注解：通过@Repeatable注解目标注解，目标注解可以重复注解；
- 扩展注解的支持：任何东西添加注解：局部变量、泛型类、父类与接口的实现，就连方法的异常也能添加注解。

### Date/Time API

- 不变性：新的日期/时间API中，所有的类都是不可变的，这对多线程环境有好处。

- 关注点分离：新的API将人可读的日期时间和机器时间（unix timestamp）明确分离，它为日期（Date）、时间（Time）、日期时间（DateTime）、时间戳（unix timestamp）以及时区定义了不同的类。

- 清晰：在所有的类中，方法都被明确定义用以完成相同的行为。举个例子，要拿到当前实例我们可以使用now()方法，在所有的类中都定义了format()和parse()方法，而不是像以前那样专门有一个独立的类。为了更好的处理问题，所有的类都使用了工厂模式和策略模式，一旦你使用了其中某个类的方法，与其他类协同工作并不困难。

- 实用操作：所有新的日期/时间API类都实现了一系列方法用以完成通用的任务，如：加、减、格式化、解析、从日期/时间中提取单独部分，等等。

- 可扩展性：新的日期/时间API是工作在ISO-8601日历系统上的，但我们也可以将其应用在非IOS的日历上。

---

## Reference

[1] [Java8新特性](http://www.importnew.com/11908.html#NewFeatureOfLanguage)

[2] [What's New in JDK 8](http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html)

[3] [Java 8 日期/时间（Date Time）API指南](http://www.codeceo.com/article/java-8-date-time-api.html)

[4] http://www.javacodegeeks.com/2014/04/java-8-date-time-api-tutorial-localdatetime.html

[5] http://rogachev.dlinkddns.com:8080/Copy/Computing/functional_programming_for_java_developers.pdf

[6] http://cfile28.uf.tistory.com/attach/250C874B52DCD4A20F56B7

[7] http://www.coreservlets.com/java-8-tutorial/
