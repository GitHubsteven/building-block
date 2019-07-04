package com.variety.shop.indi.collection.Tool;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/5/25
 * @Time: 16:05
 * @Description:
 * @version: 1.0.0
 */
public class CollectionTest {
    public static void main(String[] args) {
//        Integer[] ints = {1, 2, 3};
//        List<Integer> list1 = Arrays.asList(ints);
//
//        Integer[] newInts = {3, 2, 1};
//        List<Integer> list2 = Arrays.asList(newInts);
//
//        boolean equalCollection = CollectionUtils.isEqualCollection(list1, list2);
//        System.out.println(equalCollection);

//        Map<Integer, String> test = new HashMap<>();
//        test.put(1, "a");
//        test.put(2, "b");
//
//        List<Integer> sorted = new ArrayList<>();
//        sorted.add(2);
//        sorted.add(1);
//
//        Map<String, String> newTest = new LinkedHashMap<>();
//        for (Integer integer : sorted) {
//            newTest.put(integer+"",test.get(integer));
//        }
//        System.out.println(newTest);

//        double x = 100000000D;
//        NumberFormat numberFormat = NumberFormat.getNumberInstance();
//        numberFormat.setGroupingUsed(false);
//        System.out.println(numberFormat.format(x));

        String  x= ",,";
        String[] split = x.split(",");
        System.out.println(split.length);
        for (String sbu: split){
            System.out.println(sbu);
        }

        System.out.println();
    }
}