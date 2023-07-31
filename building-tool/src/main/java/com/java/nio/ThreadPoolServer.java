/**
 * @author: asx
 * @date: 2023/7/27
 * @descrition:
 */
package com.java.nio;

import java.util.concurrent.*;

/**
 * @author: asx
 * @date: 2023/7/27
 * @descrition:
 */
public class ThreadPoolServer extends DemoServer {
    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(4, 4, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    @Override
    public void process(RequestHandler handler) {
        EXECUTOR_SERVICE.execute(handler);
    }
}
