### http请求和请求线程池
1. http://www.javabyexamples.com/connection-pooling-using-apache-httpclient-4
2. [httpClient系列](http://ifeve.com/%e3%80%8ahttpclient%e5%ae%98%e6%96%b9%e6%96%87%e6%a1%a3%e3%80%8b1-3-http%e6%89%a7%e8%a1%8c%e4%b8%8a%e4%b8%8b%e6%96%87/)
#### 请求线程池
1. 增加了请求线程池管理会增加高数量的效率，减少请求线程的创建消耗，但是源码没看，不知道怎么实现的
2. Keep-Alive是否起作用在case代码中是没有体现的。

#### 知识点
1. HttpClient 接口的实现是线程安全的。建议执行多次请求都使用该类的同一个实例。

#### 问题
#### connection management
1. 怎么创建一个请求
2. 怎么传参
3. 怎么运行一个请求
4. 怎么管理连接，和链接持
5. 长链接，长链接策略
6. 多线程下的链接管理
7. 链接的安全性ssl(security socket layer)和tls(transfer layer security)
8. 代理，proxy
9. redirect 和redirect chain
10. cookie and session
11. state management, 状态码和对应的状态

##### state management

