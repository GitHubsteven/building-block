package com.variety.shop.indi.thread;

/**
 * Created by rongbin.xie on 2017/11/23.
 */
public class BusinessService {
    protected static class DataCache {
        private Integer seq;
        private static  final Integer instanceNum = 1;
        private  static DataCache dataCache = null;

//        public DataCache() {
//            dataCache = new DataCache();
//        }

        static DataCache instance() {
            if (null == dataCache) {
                dataCache = new DataCache();
                System.out.println("instance");
            }
            return dataCache;
        }

        Integer getSeq() {
            setSeq(seq + 1);
            return seq;
        }

        void setSeq(Integer seq) {
            this.seq = seq;
        }
    }

    private static ThreadLocal<DataCache> localVar = new ThreadLocal<>();

    public void functionSet(String threadName, int i) {
        DataCache dataCache = DataCache.instance();
        dataCache.setSeq(i);
        localVar.set(dataCache);
    }

    public Integer continueFunctionSet() {
        DataCache dataCache = localVar.get();
        return dataCache.getSeq();
    }

}
