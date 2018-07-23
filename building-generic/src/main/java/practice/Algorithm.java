package practice;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/20
 * @Time: 17:06
 * @Description:
 * @version: 1.0.0
 */
public final class Algorithm {
    public static <T> int countIf(Collection<T> collection, UnaryPredicate<T> predicate) {
        int count = 0;
        for (T ele : collection) {
            if (predicate.test(ele)) ++count;
        }
        return count;
    }

}