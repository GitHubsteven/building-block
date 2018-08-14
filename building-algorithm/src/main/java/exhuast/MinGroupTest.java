package exhuast;

import util.CollectionHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinGroupTest {
    public static void main(String[] args) {
        splitOrder();
    }

    public static void splitOrder() {
        int MAX_SIZE = 4;
        int MAX_AMOUNT = 20;
        int[] data = {14, 13, 12, 11, 10, 8, 7, 7, 4, 3, 3, 1};

        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(data);
        for (int i = MAX_SIZE; i >= 1; i--) {
            combinations.addAll(CollectionHelper.combine(data, i));
        }
        List<Integer> sums = combinations.stream().map(list -> MAX_AMOUNT - list.stream().mapToInt(t -> t).sum())
                .collect(Collectors.toList());
        int min = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < sums.size(); i++) {
            if (sums.get(i) >= 0) {
                if (sums.get(i) < min) {
                    min = sums.get(i);
                    index = i;
                }
            }
        }
        System.out.println(combinations.get(index));
    }

}
