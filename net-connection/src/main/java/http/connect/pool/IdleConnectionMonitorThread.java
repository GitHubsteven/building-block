package http.connect.pool;

import org.apache.http.conn.HttpClientConnectionManager;

import java.util.concurrent.TimeUnit;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/12/30
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class IdleConnectionMonitorThread extends Thread {
    private final HttpClientConnectionManager connectionManager;

    private volatile boolean shutdown;

    public IdleConnectionMonitorThread(HttpClientConnectionManager connectionManager) {
        super();
        this.connectionManager = connectionManager;
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    connectionManager.closeExpiredConnections();
                    connectionManager.closeIdleConnections(30, TimeUnit.SECONDS);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
