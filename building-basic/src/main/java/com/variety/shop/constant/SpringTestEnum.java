package com.variety.shop.constant;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by rongbin.xie on 2018/2/7.
 */
public class SpringTestEnum {
    public enum GeneralEnum{
        FEMALE(0),
        MALE(1);

        private Integer val;

        GeneralEnum(Integer val) {
            this.val = val;
        }

         public Integer getVal(){
            return val;
        }

        public static GeneralEnum getGeneralNullable(Integer val){
            return Arrays.stream(GeneralEnum.values())
                    .filter( it->Objects.equals(it.getVal(),val))
                    .findFirst()
                    .orElse(null);
        }
    }
}
