package structure.queue;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/3/4
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@ToString
public class XDelayTask implements Delayed {
    /**
     * name
     */
    private String name;
    /**
     * time to expire in ms
     */
    private Integer expiredTime;


    public XDelayTask(String name, Integer expiredTime) {
        this.name = name;
        this.expiredTime = expiredTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long delay = expiredTime - System.currentTimeMillis();
        return unit.convert(delay, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Integer.compare(this.getExpiredTime(), ((XDelayTask) o).getExpiredTime());
    }

}
