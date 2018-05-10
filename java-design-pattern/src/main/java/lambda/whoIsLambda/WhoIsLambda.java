package lambda.whoIsLambda;

import java.util.function.BinaryOperator;
import java.util.function.LongToDoubleFunction;

/**
 * lambda test
 * anonymous method? class? is function object, like javascript function object.Difference between is that;
 *
 * lambda params are the function<P,P1,P2....R> =======> params is Px , and the result type is R.
 * javascript
 *
 * Created by rongbin.xie on 2018/3/21.
 */
public class WhoIsLambda {
    public static void main(String[] args) {
        BinaryOperator<Integer> addInteger = (x, y) -> x + y;
        LongToDoubleFunction todouble = (x) -> x/3;
        Integer apply = addInteger.apply(1, 2);

        double s = todouble.applyAsDouble(3L);

    }
}
