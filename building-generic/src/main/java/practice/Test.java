package practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/20
 * @Time: 22:38
 * @Description:
 * @version: 1.0.0
 */
public class Test {
    static class RelativelyPrimedicate implements UnaryPredicate<Integer> {
        private Collection<Integer> c;

        public RelativelyPrimedicate(Collection<Integer> c) {
            this.c = c;
        }


        @Override
        public boolean test(Integer obj) {
            for (Integer i : c) {
                if (RelativePrime.gcd(obj, i) != 1) return false;
            }
            return c.size() > 0;
        }
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(3, 4, 6, 8, 11, 15, 28, 32);
        Collection<Integer> c = Arrays.asList(7, 18, 19, 25);
        UnaryPredicate<Integer> p = new RelativelyPrimedicate(c);

        int i = RelativePrime.findFirst(li, 0, li.size(), p);
        if (i != -1) {
            System.out.print(li.get(i) + " is relatively prime to ");
            for (Integer k : c)
                System.out.print(k + " ");
            System.out.println();
        }

    }
}