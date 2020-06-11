##### 参考文章
1. [Talking about Parameterizedtype,genericarraytype,typevariabl,wildcardtype_java in Java type](https://topic.alibabacloud.com/a/talking-about-parameterizedtypegenericarraytypetypevariablwildcardtype_java-in-java-type_1_27_20160378.html)
2. [我眼中的Java-Type体系-1](https://cloud.tencent.com/developer/article/1121266)
3. [我眼中的Java-Type体系-2](https://cloud.tencent.com/developer/article/1121268)
4. [关于Java泛型"擦除"的一点思考](https://cloud.tencent.com/developer/article/1121230?from=10680)

##### 泛型
java的泛型其实并不是真正的泛型，只是存在编译的过程中，编译成class后，泛型会被擦除。
> 说到泛型，就不得说起“擦除”这个概念，相比于c#来说，java的泛型只存在于程序的源码中，在编译后的class文件中不存在，
>这个过程就是--泛型"擦除"；所以，对于new ArrayList<String> 和 new ArrayList<Integer> 来说，两个对象在编译之后两者是一样的，通过反射均可以向集合中添加任意类型的对象；

擦除：如果在变量声明中，动态的赋值给parameterizedType，如List<String>, List<Integer>的话，在编译过程中会被擦除，但是如果声明了类的话（无论
是显示的还是匿名的类），在编译的过程中，都会为类生成相应的类型信息，并且把parameterizedType的父类默认为原始类型，那么就可以保存parameterizedType
的信息，那么就可以保持完整的数据信息了。

| index | Name      | Example |
| -----------| ----------- | ----------- |
|1 | ParameterizedType      | 参数化类型，即泛型；例如：List<T>、Map<K,V>等带有参数化的对象，自定义的如Box<T>也是 |
|2 | TypeVariable   | 类型变量，即泛型中的变量；例如：T、K、V等变量，可以表示任何类；在这需要强调的是，TypeVariable代表着泛型中的变量，而ParameterizedType则代表整个泛型     |
|3 | GenericArrayType      | 泛型数组类型，用来描述ParameterizedType、TypeVariable类型的数组；即List<T>[] 、T[]等 |
|4 | Class   | Class是Type的一个实现类，属于原始类型，是Java反射的基础，对Java类的抽象        |
|5 | WildcardType   | 泛型表达式（或者通配符表达式），即？ extend Number、？ super Integer这样的表达式；WildcardType虽然是Type的子接口，但却不是Java类型中的一种        |


