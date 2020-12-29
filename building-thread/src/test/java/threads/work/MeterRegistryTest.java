package threads.work;

import io.micrometer.core.instrument.LongTaskTimer;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/21
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MeterRegistryTest {
    @Test
    public void test() {
        SimpleMeterRegistry registry = new SimpleMeterRegistry();
        Timer timer = registry.timer("app.event");
        timer.record(() -> {
            try {
                TimeUnit.MICROSECONDS.sleep(1500);
            } catch (InterruptedException ignored) {
            }
        });
        timer.record(3000, MILLISECONDS);

        assertEquals(2, timer.count());
        assertTrue(4510 > timer.totalTime(MILLISECONDS)
                && 4500 <= timer.totalTime(MILLISECONDS));
    }

    @Test
    public void testLongTimer() {
        SimpleMeterRegistry registry = new SimpleMeterRegistry();
        final LongTaskTimer longTaskTimer = LongTaskTimer.builder("longTaskTimer")
                .register(registry);

        long currentTaskId = longTaskTimer.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long timeElapsed = longTaskTimer.stop(currentTaskId);
        assertEquals(2, timeElapsed / (int) 1e9);
    }

    @Test
    public void test1e9() {
        System.out.println(1e9);
    }
}
