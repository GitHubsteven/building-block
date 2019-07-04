package com.variety.shop.indi.report;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rongbin.xie on 2017/3/8.
 */
@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class Main {
    public static void main(String[] args) {
        Integer BUFFER_SIZE = 1000;
        StringBuilder filePath = new StringBuilder("E://IoFile//resource//");
        StringBuilder fileName = new StringBuilder("input.txt");
        StringBuilder outFilePath = new StringBuilder("E://IoFile//output//");
        StringBuilder outFileName = new StringBuilder("output.txt");
        ArrayList<BaseBean> list = new ArrayList<>();
        //计算一百万条数据
        for (int i = 0; i < 1000000; i++) {
            BaseBean bean = new BaseBean().setCommon1("c1" + i).setCommon2("c2" + i).setCommon3("c3" + i).setCommon4("c3" + i);
            list.add(bean);
        }
//        for()
//
        list.forEach(bean -> {
        });
        byte[] buffer1 = new byte[BUFFER_SIZE];
        long startTime = System.currentTimeMillis();
        try {
            byte[] buffer = new byte[BUFFER_SIZE];
            FileInputStream fip = new FileInputStream(filePath.append(fileName).toString());
            FileOutputStream fop = new FileOutputStream(outFilePath.append(outFileName).toString(),true);
            for (int i = 0; i < 4; i++) {

            }
            fip.read(buffer);
            fop.write(buffer);
            int count = 1;
            while (fip.read(buffer, 0, BUFFER_SIZE) > -1 && count < 4) {
                fop.write(buffer);
                count++;
            }
            fop.close();

            System.out.println("count = " + count);
            System.out.println(System.currentTimeMillis() - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
