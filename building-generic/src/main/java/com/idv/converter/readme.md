#### java 类型的强制转化 ####

###### 场景 ######
对于共同封装来说，忽略类型来说是很常见的，在某种通用的传参时我们会使用Object来作为参数类型来接受各种各样的类型，最后在
需要使用的时候我们会强制转化类型，通常我们知道，只有一下两种情形可以强制转化
1. 子类转化为父类
2. 声明为父类但实际上是子类，那么父类就可以转化为子类

否则就会报**ClassCastException**错，经典的ArrayList的实现，我们可以看到，get(int index)的源码，实际的数据容器是个数组，最初获取到的数据是Object，
只不过在返回的时候会强制转化而已
```
    transient Object[] elementData;

    public E get(int index) {
        rangeCheck(index);

        return elementData(index);
    }
    //强制类型转化
     @SuppressWarnings("unchecked")
     E elementData(int index) {
        return (E) elementData[index];
    }
```

在上面的java代码中我们可以看到elementData是Object数组类型。

##### 关于编译 #####
我们知道，在开发过程中编译器为了尽量避免ClassCastException异常，定义通常会指定尽量详细的类型，不会是Object,因为如果是Object的话
那么，集合数据就变化性太大了，通常来说这是基本常识。通常如下代码会报错
```
        List<Integer> number = new ArrayList<>();
        String ele = "345";
        number.add(ele)
```
那是因为编译器会进行类型检测，但是下面的代码却不会
```
 List<Object> datas = new ArrayList<>();
        datas.add("string");
        datas.add(123);
```

List<T> tList = new ArrayList<>();
通常表示tList可以操作T及其子类，虽然不知道tList的具体子类可以由"个人开发人员"自定义类型并且保持正确的类型转化从而保持代码的正常
运行，但是从代码的可维护性来说，这简直是致命的。
1. 代码可读性极其糟糕，其他程序员会觉得这种代码会及其奇怪，无法理解，从而要花费超多时间去理解和重构
2. 如果这种代码开放给别人使用，使用者根本无法使用
3. 违反java的开发职能专一原则，由于Object几乎适用所有的子类，那么这个代码必定涉及极多的业务交互，否则没必要设计成这样，那么
这也会增大代码维护的成本。

在共同开发中，有时不可避免会出现这种问题，但是在业务开发中，这几乎是不可饶恕的，但是在有些共同的开发过程中，这样写法也改遵循
下面的几个原则：
1. 能尽量不用的话，那么就不用
2. 如果用那么尽早转化为确定的类型
3. 尽量在底层中转化，涉及到的层数尽量少

在下面的case很经典
```
    public static void main(String[] args) {
        CommonBox<Long> box = getBox();
        Long x = box.get();
        System.out.println(x);
    }

    private static CommonBox<Long> getBox() {
        //这个数据也许是第三方的库如ObjectMapper，或者api接口返回
        CommonBox box = new CommonBox(123);
        return box;
    }
```
通常来说，这是可以编译和运行的，注意注释，这表示数据源box是可能未知的，可能你从哪个渠道，如api文档说明或者啥的，说明了这是Long类型
所以很放心的做为CommonBox<Long>来返回了，ok，一切很完美，至于那些IDEA报警报什么的，没有把他们设为 @SuppressWarnings("unchecked")
就很给面子了。至于从CommonBox这个数据类型转化到CommonBox<Long>这个类型，反正据我所知都是一样的，我确定，我坚信，没问题的，一切ok
，这在简单的一层当然是没问题的，呵呵。你把CommonBox ->CommonBox<Long>这个工程交个虚拟机来就是在逗我！

如果你在涉及到xml/json的复杂转化的话，这几乎不可行（这个另外谈）。作为java程序员，我们必须尽量的保持准确，不能说猫，就变成了猫科
动物，作为猫科动物，猫和老虎还是有很大的区别的。

##### 解决方案 #####
问题出现的原因之一是开发人员偷懒，解决这个问题必须有程序员想办法，我们通常在转化数据过程中，**手动**定好类型在java中非常重要的，
我们通常在方法中指定参数类型，或者通过某种代码层面上的渠道确定类型，在返回之前**手动**确定类型，代码如下
```
    private static <T> CommonBox<T> getBox(Class<T> tClass) {
        //这个数据也许是第三方的库如ObjectMapper等
        T t;
        try {
            t = tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("instance exception!");
        }
        return new CommonBox<>(t);
    }
```
或者如ArrayList中操作一样。
```
    private static CommonBox<Long> getBox1() {
        //此时如果你不能确定类型
        CommonBox box = new CommonBox(123L);
        //转化类型
        return new CommonBox<>((Long) box.get());
    }
```

注意：千万别滥用Object作为参数随便传递参数。