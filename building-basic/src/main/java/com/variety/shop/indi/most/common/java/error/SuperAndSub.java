package com.variety.shop.indi.most.common.java.error;

/**
 * Created by rongbin.xie on 2017/9/14.
 */
public class SuperAndSub {
    class Super{
        private String name;

        public Super(String name) {
            this.name = name;
        }
    }

    class Sub extends Super{
        private Integer age;
        Sub(String s){
            super(s);
        }
    }
}
