package com.variety.shop.indi.collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by rongbin.xie on 2018/2/8.
 */
public class TransferColumAndLine {
    public static void main(String[] args) {
        Map<String, String> typeValue = new HashMap<>();

        typeValue.put("0", "OFFLINE_PICK_UP");
        typeValue.put("1", "SINGLE_PICK_UP");
        typeValue.put("2", "MULTIPLE_PICK_UP");
        typeValue.put("3", "MULTIPLE_ACROSS_PICK_UP");
        typeValue.put("4", "ON_SHELF");
        typeValue.put("5", "OFF_SHELF");
        typeValue.put("6", "WAITING_RETURN");
        typeValue.put("7", "WAITING_SHIP");
        typeValue.put("8", "PUT_INTO_WAITING_AREA");
        typeValue.put("9", "PRINT");


        //0-3
        List<Integer> firstShow = Arrays.asList(1, 2, 3, 4, 6, 7, 13);
        List<Integer> secondShow = Arrays.asList(3, 4, 10, 11, 12);
        List<Integer> thirdShow = Arrays.asList(3, 4, 7, 10, 11, 12);
        List<Integer> forthShow = Arrays.asList(5, 7);
        List<Integer> fifthShow = Arrays.asList(1, 3, 4, 7);

        Map<Integer, List<Integer>> taskTypeToColumn = new HashMap<>();
        taskTypeToColumn.put(0, firstShow);
        taskTypeToColumn.put(1, firstShow);
        taskTypeToColumn.put(2, firstShow);
        taskTypeToColumn.put(3, firstShow);

        taskTypeToColumn.put(4, secondShow);
        taskTypeToColumn.put(5, thirdShow);

        taskTypeToColumn.put(6, forthShow);
        taskTypeToColumn.put(7, forthShow);
        taskTypeToColumn.put(8, fifthShow);
        taskTypeToColumn.put(9, fifthShow);

        Map<Integer, List<Integer>> columnToTypes = new HashMap<>();
        List<String> showSentences = new ArrayList<>();

        for (int columnIndex = 1; columnIndex <= 13; columnIndex++) {
            int finalColumnIndex = columnIndex;
            List<String> types = taskTypeToColumn.entrySet()
                    .stream()
                    .filter(it -> {
                        List<Integer> columns = it.getValue();
                        return columns.contains(finalColumnIndex);
                    }).map(it -> "TASK_TYPE." + typeValue.get("" + it.getKey()))
                    .distinct()
                    .collect(Collectors.toList());
//            columnToTypes.put(finalColumnIndex,types);
            List<String> typesName = new ArrayList<>();
            System.out.println("let showColumn" + finalColumnIndex + " = " + types + ";");
            showSentences.add(String.format("  this.gridOptions.columnDefs[%d].visible = showColumn%s.findIndex(type) > -1;", finalColumnIndex, finalColumnIndex));

        }
        System.out.println("=====================");
        showSentences.forEach(System.out::println);
    }
}
