package com.variety.shop.indi.report.Streams;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dell on 2017/2/16.
 */
public class Generic {
    public static void main(String[] args) {
        dealData(new Boys());
    }
    public static  <T> void dealData( T t)
    {
        if(t instanceof  Boys)
        {
            ((Boys) t).iAmABoy();
        }else if(t instanceof Girl)
        {
            ((Girl) t).LovedStar();
        }
    }
    public static  <T> void setCharacterAge(List <T> list)
    {
        if(null == list)
        {
            return;
        }
        else
        {
            Iterator iterator = list.iterator();
//            T t = (T) iterator.next();
            while (iterator.hasNext())
            {
                T t = (T) iterator.next();
                Class tClazz =t.getClass();
                Field[] fields = tClazz.getDeclaredFields();
            }
        }
    }

    public static  void testFather (List<? extends  Man> list)
    {
        Iterator iterator =  list.iterator();
        while ( iterator.hasNext())
        {
            Man element = (Man)iterator.next();
            element.setName("haha");
        }
    }
}
