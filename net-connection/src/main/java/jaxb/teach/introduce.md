Marshaller接口，将Java对象序列化为XML数据。 
Unmarshaller接口，将XML数据反序列化为Java对象。

@XmlType，将Java类或枚举类型映射到XML模式类型 

@XmlAccessorType(XmlAccessType.FIELD) ，控制字段或属性的序列化。FIELD表示JAXB将自动绑定Java类中的每个非静态的（static）、非瞬态的（由@XmlTransient标 注）字段到XML。其他值还有XmlAccessType.PROPERTY和XmlAccessType.NONE。 

@XmlAccessorOrder，控制JAXB 绑定类中属性和字段的排序。 

@XmlJavaTypeAdapter，使用定制的适配器（即扩展抽象类XmlAdapter并覆盖marshal()和unmarshal()方法），以序列化Java类为XML。 

@XmlElementWrapper ，对于数组或集合（即包含多个元素的成员变量），生成一个包装该数组或集合的XML元素（称为包装器）。 

@XmlRootElement，将Java类或枚举类型映射到XML元素。 

@XmlElement，将Java类的一个属性映射到与属性同名的一个XML元素。 

@XmlAttribute，将Java类的一个属性映射到与属性同名的一个XML属性。

---------------------

本文来自 Ricky_Fung 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/top_code/article/details/51660191?utm_source=copy 