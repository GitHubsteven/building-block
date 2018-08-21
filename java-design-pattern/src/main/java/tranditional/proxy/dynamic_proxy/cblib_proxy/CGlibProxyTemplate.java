package tranditional.proxy.dynamic_proxy.cblib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 继承了方法拦截器
 */
public class CGlibProxyTemplate implements MethodInterceptor {

    private static CGlibProxyTemplate proxyCreator = new CGlibProxyTemplate();

    private CGlibProxyTemplate() {
    }

    public static CGlibProxyTemplate getInstance() {
        return proxyCreator;
    }


    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz) {
        return (T) Enhancer.create(clazz, this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void before() {
        System.out.println("======================before");
    }

    private void after() {
        System.out.println("=======================after");
    }
}
