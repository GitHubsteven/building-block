/**
 * @author: asx
 * @date: 2022/10/26
 * @descrition:
 */
package com.demo.asa.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public Map<Integer,Integer>  map = new ConcurrentHashMap<>(3);

    public static void main(String[] args) {
        Map<Integer, Integer> aMap = new AMap<>(2);
        for (int i = 0; i < 20; i++) {
            aMap.put(i, i);
        }

        System.out.println(aMap.get(15));
        aMap.remove(15);
        System.out.println(aMap.get(15));
    }

    public void testMultipleTread(Map<String, String> map) {

    }

    public class AThread extends Thread {
        private Map<Integer, Integer> dataCache;
        private int start = 0;

        public AThread(Map<Integer, Integer> dataCache, int start) {
            this.dataCache = dataCache;
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                dataCache.put(i, i + start);
            }
        }
    }
}
