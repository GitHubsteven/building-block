package threads.work;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BigDecimalSplitOrderTest {
    public static void main(String[] args) {
        List<BigDecimal> dataSet = getDateSet();
        List<List<BigDecimal>> maxGroups = BigDecimalSplitOrder.instance()
                .getMaxValOfCombines(dataSet, new BigDecimal("100"), Math.floorDiv(dataSet.size(), 2), BigDecimal::add, BigDecimal.ZERO);
        maxGroups.forEach(it -> {
            System.out.println("----------------------------");
            it.forEach(el -> System.out.print(el + "\n"));
        });
    }

    private static List<BigDecimal> getDateSetFromStr() {
        List<BigDecimal> dataSet = new ArrayList<>();
        String dataStr = "600\t499\t200\t100\t50\t499\t299\t350\t10\n";
        String[] dataArr = dataStr.split("\\s");

        for (String aDataArr : dataArr) {
            dataSet.add(new BigDecimal(aDataArr));
        }
        return dataSet;
    }

    private static List<BigDecimal> getDateSet() {
        List<BigDecimal> dataSet = new ArrayList<>();
        for (int i = 1; i <= 150; ) {
            dataSet.add(new BigDecimal("" + i));
            i += 5;
        }
        return dataSet;
    }
}
