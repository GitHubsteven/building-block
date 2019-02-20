##### xstream 中指定序列化过程中属性的顺序

需求：在使用xstream转化Javabean->xml的过程中，有时候，我们需要指定xml化的顺序，xstream默认的是按字符定义的顺序来xml化的，
但是，有的时候如果我们使用的继承某些class，而无法改变的时候，这就非常难办了。

解决方案一：

官方给了一个类：通过 com.thoughtworks.xstream.converters.reflection.FieldDictionary.来实现指定xml化的顺序字典，
可以参考例子[地址](https://www.programcreek.com/java-api-examples/index.php?api=com.thoughtworks.xstream.converters.reflection.FieldDictionary)：
```
public void testSortsFieldOrderWithArray() {

        SortableFieldKeySorter sorter = new SortableFieldKeySorter();
        sorter.registerFieldOrder(MommyBear.class,
                new String[]{"absde", "absese", "accsed", "money"});

        XStream xstream = new XStream(new PureJavaReflectionProvider(new FieldDictionary(sorter)));
        xstream.alias("mommy", MommyBear.class);
        MommyBear root = new MommyBear();
        root.absde = "ccc";
        root.absese = "bbb";
        root.accsed = "aaa";
//        root.money = "12";
        System.out.println(xstream.toXML(root));
    }

    public static class MommyBear implements Serializable {
        String absde;
        String absese;
        String accsed;
        String money;
    }
```
然而通过这个方式有缺点，那就是如果有N个属性成员，如果有没有指定的话，那么会报错。而且不具备通用性，如果有M个类需要指定的话，那么
工作量也是非常大的。
为了解决这个问题，我们可以参考Stack Overflow的这个[解决方案](https://stackoverflow.com/questions/16978651/how-to-annotation-order-field-when-using-xstream-on-android)

解决方案二：

1. 定义一个声明：
```
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface XMLSequence {
    String[] value();
}
```
2. 生成一个FieldKeySorter的实现类，用来注入xstream实例中
```
public class SequenceFieldKeySorter implements FieldKeySorter {
    @Override
    public Map sort(final Class type, final Map keyedByFieldKey) {
        Annotation sequence = type.getAnnotation(XMLSequence.class);
        if (sequence != null) {
            final String[] fieldsOrder = ((XMLSequence) sequence).value();
            Map result = new LinkedHashMap();
            Set<Map.Entry<FieldKey, Field>> fields = keyedByFieldKey.entrySet();
            for (String fieldName : fieldsOrder) {
                if (fieldName != null) {
                    for (Map.Entry<FieldKey, Field> fieldEntry : fields) {
                        if
                                (fieldName.equals(fieldEntry.getKey().getFieldName())) {
                            result.put(fieldEntry.getKey(),
                                    fieldEntry.getValue());
                        }
                    }
                }
            }
            return result;
        } else {
            return keyedByFieldKey;
        }
    }
}
```
3. 把fieldSorter 的实现类注入到xStream中，代码如下：
```
  XStream xStream = new XStream(new PureJavaReflectionProvider(new FieldDictionary(new PartialSeqFieldKeySorter())));
```

在方案而中，如果有了XmlSequence声明，如下：
```java
@Setter
@Getter
@XMLSequence({"imID", "zipCode"})
public class Buyer {
    private String email;
    private String zipCode;
    private String address;
    private String imID;
    private String name;
    private String phone;
    private String mobile;
}
```
如果你声明中只定义了N-x个的话，那么，剩下的都不会被xml化，结果如下(address没有被xml化)：
```xml
<buyer>
  <imID>imId001</imID>
  <zipCode>00001</zipCode>
</buyer>
```
这是个问题，我们需要声明所有的属性，对于多属性成员来说，这是不可取的。为了
解决这个问题，我们重新实现SequenceFieldKeySorter中的 public Map sort(Class type, Map keyedByFieldKey) 方法，代码如下：
```
 @Override
    public Map sort(Class type, Map keyedByFieldKey) {
        Annotation sequence = type.getAnnotation(XMLSequence.class);
        if (sequence != null) {
            final String[] fieldsOrder = ((XMLSequence) sequence).value();
            Map<FieldKey, Field> custom = new LinkedHashMap<>();
            Map<FieldKey, Field> notCustom = new LinkedHashMap<>();
            Set<Map.Entry<FieldKey, Field>> fields = keyedByFieldKey.entrySet();
            for (String fieldName : fieldsOrder) {
                if (fieldName != null) {
                    for (Map.Entry<FieldKey, Field> fieldEntry : fields) {
                        if (fieldName.equals(fieldEntry.getKey().getFieldName())) {
                            custom.put(fieldEntry.getKey(), fieldEntry.getValue());
                        } else {
                            notCustom.put(fieldEntry.getKey(), fieldEntry.getValue());
                        }
                    }
                }
            }
            custom.putAll(notCustom);
            return custom;
        } else {
            return keyedByFieldKey;
        }
    }
```
两者的区别在于这里我们实现了如果没有声明的，我们也加进返回结果中了
```
for (Map.Entry<FieldKey, Field> fieldEntry : fields) {
                        if (fieldName.equals(fieldEntry.getKey().getFieldName())) {
                            custom.put(fieldEntry.getKey(), fieldEntry.getValue());
                        } else {
                            notCustom.put(fieldEntry.getKey(), fieldEntry.getValue());
                        }
                    }
                    //没有定义的添加到结果中
                     custom.putAll(notCustom);
                                return custom;
```
重新定义一个类：
```
public class PartialSeqFieldKeySorter implements FieldKeySorter {
    @Override
    public Map sort(Class type, Map keyedByFieldKey) {
        Annotation sequence = type.getAnnotation(XMLSequence.class);
        if (sequence != null) {
            final String[] fieldsOrder = ((XMLSequence) sequence).value();
            Map<FieldKey, Field> custom = new LinkedHashMap<>();
            Map<FieldKey, Field> notCustom = new LinkedHashMap<>();
            Set<Map.Entry<FieldKey, Field>> fields = keyedByFieldKey.entrySet();
            for (String fieldName : fieldsOrder) {
                if (fieldName != null) {
                    for (Map.Entry<FieldKey, Field> fieldEntry : fields) {
                        if (fieldName.equals(fieldEntry.getKey().getFieldName())) {
                            custom.put(fieldEntry.getKey(), fieldEntry.getValue());
                        } else {
                            notCustom.put(fieldEntry.getKey(), fieldEntry.getValue());
                        }
                    }
                }
            }
            custom.putAll(notCustom);
            return custom;
        } else {
            return keyedByFieldKey;
        }
    }
}
```
这样我们就可以只定义自己需要的属性成员就可以了，不改变上面Buyer.class的声明，这里我们可以生成所有的不为空的成员
```xml
<buyer>
  <imID>imId001</imID>
  <zipCode>00001</zipCode>
  <address>sh.cn</address>
</buyer>
```
结果正好！

测试类参考：