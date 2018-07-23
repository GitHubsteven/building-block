package customfunction;

import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/20
 * @Time: 17:47
 * @Description:
 * @version: 1.0.0
 */
@FunctionalInterface
public interface CustomFunction<R> {
    R run(Object[] params);
}