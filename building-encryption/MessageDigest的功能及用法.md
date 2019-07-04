##### 参考文章系列
[MessageDigest的功能及用法](https://www.cnblogs.com/honey01/p/6420111.html)


MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。

MessageDigest 对象开始被初始化。该对象通过使用 update（）方法处理数据。任何时候都可以调用 reset（）方法重置摘要。一旦所有需要更新的数据都已经被更新了，应该调用digest() 方法之一完成哈希计算。

对于给定数量的更新数据，digest 方法只能被调用一次。在调用 digest 之后，MessageDigest 对象被重新设置成其初始状态。

1 public static MessageDigest getInstance(String algorithm)
                                 throws NoSuchAlgorithmException
   返回实现指定摘要算法的 MessageDigest 对象。
   algorithm - 所请求算法的名称
   
2 public static MessageDigest getInstance(String algorithm,
                                        String provider)
                                 throws NoSuchAlgorithmException,
                                        NoSuchProviderException
  返回实现指定摘要算法的 MessageDigest 对象。
  algorithm - 所请求算法的名称
  provider - 提供者的名称。
  
3 public void update(byte[] input)
  使用指定的 byte 数组更新摘要。 
  
4 public byte[] digest()
  通过执行诸如填充之类的最终操作完成哈希计算。在调用此方法之后，摘要被重置。
  
5 public static boolean isEqual(byte[] digesta,
                              byte[] digestb)
比较两个摘要的相等性。做简单的字节比较。
 

注意：Provider可以通过 Java.security.Security.getProviders() 方法获取已注册提供者列表。比较常用的有“SUN”

SUN提供的常用的算法名称有：
- MD2 
- MD5 
- SHA-1 
- SHA-256 
- SHA-384 
- SHA-512