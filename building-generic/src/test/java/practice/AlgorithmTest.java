package practice;

import java.util.Arrays;
import java.util.Collection;

public class AlgorithmTest {
    public static void main(String[] args) {
        AlgorithmTest test = new AlgorithmTest();
        test.countIf();
    }


    public void countIf() {
        Collection<Integer> collectors = Arrays.asList(1, 2, 3, 4);
        int count = Algorithm.countIf(collectors, (i) -> i % 2 != 0);
        System.out.println("number of odd integers = " + count);
    }

    class OddPredicate implements UnaryPredicate<Integer> {
        @Override
        public boolean test(Integer obj) {
            return obj % 2 != 0;
        }
    }
}
