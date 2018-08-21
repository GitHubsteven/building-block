package tranditional.proxy.dynamic.cglibdyn;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/16
 * @Time: 17:33
 * @Description:
 * @version: 1.0.0
 */
public class CGlibProxy implements MethodInterceptor {
    private static CGlibProxy cGlibProxy = new CGlibProxy();

    private CGlibProxy() {
    }

    public static CGlibProxy instance() {
        return cGlibProxy;
    }

    public <T> T getProxy(Class<T> cls) {
        //noinspection unchecked
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    public void before() {
        System.out.println("dyn before..........");
    }

    public void after() {
        System.out.println("dyn after..........");
    }
}