package tranditional.proxy.dynamic.jdkdyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/16
 * @Time: 16:58
 * @Description: jdk dynamic proxy by realize InvocationHandler interface
 * advantages:  avoid too many proxy class, absolutely
 * disadvantages: require object.interfaces, if one don't have interfaces, what need i do?
 * @version: 1.0.0
 */
public class DynamicProxy implements InvocationHandler {
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
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