package practice;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/20
 * @Time: 17:07
 * @Description:
 * @version: 1.0.0
 */
@FunctionalInterface
public interface UnaryPredicate<T> {
    boolean test(T obj);
}