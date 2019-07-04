package com.variety.shop.indi.report.GrandFatherAndGrandSon;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by dell on 2017/2/16.
 */
public class Main
{
    public static void main(String[] args) {
        Son son = new Son();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set set = map.keySet();
        /*System.out.println(set.size());
        System.out.println(set.contains(1));*/
        BigDecimal b1 = new BigDecimal( 10);
        BigDecimal b2= new BigDecimal(0.00);
        System.out.println(b1.compareTo(b2));
        System.out.println(b2.compareTo(BigDecimal.ZERO));
        System.out.println(b1.divide(b2));
     /*   Field[] fields =son.getClass().getFields();
        for (Field f: fields
             ) {
            System.out.println(f.getName());
        }*/
     /*   son.setOrders(1);
        son.setPriAttr("son1");
        son.setReturnRate(23);
        son.setMTD(123);
        PaPa papa = son;
        Son son1=(Son) papa;
        System.out.println(son1.getMTD());*/
  /*   String staDate ="2016-1-6";
        String endDate = "2016-1-02";
        if( staDate.compareTo(endDate) == 1 )
        {
            System.out.println("wrong!");
            return;
        }else
        {
            System.out.println("yes");
            return ;
        }
    }*/
    }
}
