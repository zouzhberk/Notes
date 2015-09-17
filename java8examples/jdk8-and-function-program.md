class: center, middle, inverse

#Java8与函数式编程思维
## Berk
## 9/18/2015

---

##Java 8 语言新特性
- Lambda表达式与Functional接口

>
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

## Java8 类库的新特新
### Optional

### Stream API

### Date/Time API

### JavaScript引擎Nashorn

### 其它
Files 
Base64


[1](Java8新特性)<http://www.importnew.com/11908.html#NewFeatureOfLanguage>

---

## Java8中的函数编程思维

---
