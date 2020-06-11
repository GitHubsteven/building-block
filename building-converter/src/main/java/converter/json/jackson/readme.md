##### Jackson和泛型
在序列化和反序列化的过程中，泛型是永远离不开的主题，那么泛型有哪几种呢？Jackson又是如何来处理这些问题的呢？或者说Jackson如何处理的呢？

##### 泛型的类型参考
| index | Name      | Example |
| -----------| ----------- | ----------- |
|1 | ParameterizedType      | 参数化类型，即泛型；例如：List<T>、Map<K,V>等带有参数化的对象，自定义的如Box<T>也是 |
|2 | TypeVariable   | 类型变量，即泛型中的变量；例如：T、K、V等变量，可以表示任何类；在这需要强调的是，TypeVariable代表着泛型中的变量，而ParameterizedType则代表整个泛型     |
|3 | GenericArrayType      | 泛型数组类型，用来描述ParameterizedType、TypeVariable类型的数组；即List<T>[] 、T[]等 |
|4 | Class   | Class是Type的一个实现类，属于原始类型，是Java反射的基础，对Java类的抽象        |
|5 | WildcardType   | 泛型表达式（或者通配符表达式），即？ extend Number、？ super Integer这样的表达式；WildcardType虽然是Type的子接口，但却不是Java类型中的一种        |

那么Jackson 是如何处理的呢？

##### Jackson的类型转化接口使用方法
```
JacksonConstant.OM.readvalue(xxx,arg[1])
```
arg[1]接受的参数类型为
1. Class
2. JavaType
3. TypeReference

class无需多说明，那么什么是JavaType，TypeReference呢？
1. JavaType:

在Jackson中可能是最终的类型吧，TypeReference最终还是会转化为JavaType，那么什么是JavaType呢？ //todo

通常的使用或者构造方式是：
```
1. 通过objectMapper.construct
JavaType javaType = JacksonConstant.OM.constructType(type);
2. 通过TypeProvier
JavaType javaType1 = TypeFactory.defaultInstance().constructType(type);
```
其实方式1本质上是2，源代码如下：
```
public JavaType constructType(Type t) {
    //本质还是通过TypeFactory来实现的
    return _typeFactory.constructType(t);
}
```

2. TypeReference:

源码如下：
```
public abstract class TypeReference<T> implements Comparable<TypeReference<T>>
{
    protected final Type _type;
    
    protected TypeReference()
    {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class<?>) { // sanity check, should never happen
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        _type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }

    public Type getType() { return _type; }
}
```
通用的使用方式是：
```
  Map<String, Staff> json2Map = JacksonConstant.OM.readValue(staffMapJson, new TypeReference<Map<String, Staff>>() {
        });
```
构建一个内部匿名类，名字是运行类下的$number，继承了TypeReference<Map<String,Staff>>，保存了最原始的数据类型，通过
```
getClass().getGenericSuperclass()
```
获取parameterizedType，类型为TypeReference，通过parameterizedType.getActualTypeArguments()[0],获取最终的类型:Map<String, Staff>，
这样的话就保留了需要的类型。

#####详细

1. 入参为class
```
Staff staff1 = mapper.readValue(jsonInString, Staff.class);
//Pretty print
String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
```
2. 入参为type
    1.如果入参的是type，但是实际上是class的话，那么需要构建JavaType 
```
 Object obj = JacksonConstant.OM.readValue(json, JacksonConstant.OM.constructType(type));
if (obj instanceof Staff) {
    return (Staff) obj;
}
```

如果入参为ParameterizedType的话，如果Map<K，V>，那么需要转化为