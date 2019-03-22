1. 父类泛型<T> 
```java
public interface Parent<T extends Comparable<T>> {
    void apply(T param1);
}
```
2. 子类定义类型，上传个父类

2.1 重新定义泛型
```java
public class UndefinedSon<T extends Comparable<T>> implements Parent<T> {
    @Override
    public void apply(T param1) {

    }
}
```
2.2  子类直接指定类型
```java
public class StringSon implements Parent<String> {
    @Override
    public void apply(String param1) {

    }
}
```
无论如何，在继承的时候，必须上传类型，不过这只是在编译的时候起作用。