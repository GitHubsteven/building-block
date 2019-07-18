package com.google.guava;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 10:53 2019/7/18.
 */
public class RateLimiterTest {
    @Test
    public void testCase1() {
        RateLimiter rateLimiter = RateLimiter.create(2);
        long startTime = ZonedDateTime.now().getSecond();
        rateLimiter.acquire(1);
        doSomeLimitedOperation();
        rateLimiter.acquire(1);
        doSomeLimitedOperation();
        long elapsedTimeSeconds = ZonedDateTime.now().getSecond() - startTime;
        assert (elapsedTimeSeconds <= 1);
    }

    private static void doSomeLimitedOperation() {
    }

    @Test
    public void givenLimitedResource_whenRequestOnce_thenShouldPermitWithoutBlocking() {
        // given
        RateLimiter rateLimiter = RateLimiter.create(100);

        // when
        long startTime = ZonedDateTime.now().getSecond();
        rateLimiter.acquire(100);
        doSomeLimitedOperation();
        long elapsedTimeSeconds = ZonedDateTime.now().getSecond() - startTime;

        // then
        assert (elapsedTimeSeconds <= 1);
    }

    @Test
    public void givenLimitedResource_whenUseRateLimiter_thenShouldLimitPermits() {
        // given
        RateLimiter rateLimiter = RateLimiter.create(100);

        // when
        long startTime = ZonedDateTime.now().getSecond();
        IntStream.range(0, 1000).forEach(i -> {
            rateLimiter.acquire();
            doSomeLimitedOperation();
        });
        long elapsedTimeSeconds = ZonedDateTime.now().getSecond() - startTime;

        // then
        assert (elapsedTimeSeconds >= 10);
    }

    @Test
    public void givenLimitedResource_whenTryAcquire_shouldNotBlockIndefinitely() {
        // given
        RateLimiter rateLimiter = RateLimiter.create(1);

        // when
        rateLimiter.acquire();
        boolean result = rateLimiter.tryAcquire(2, 10, TimeUnit.MILLISECONDS);

        // then
        Assert.isTrue(!result, "result is:" + result);
    }

    @Test
    public void testRateLimiterFactory(){
        RateLimiter.create(2);
        RateLimiter orderItemRateLimiter =  RateLimiter.create(0.8,1, TimeUnit.MINUTES);
    }
}