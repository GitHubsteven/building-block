/**
 * @author: asx
 * @date: 2023/7/27
 * @descrition:
 */
package com.java.nio;

/**
 * @author: asx
 * @date: 2023/7/27
 * @descrition:
 */
public interface IRequestHandler {
    /**
     * 处理request的方式
     *
     * @param handler
     */
    void process(RequestHandler handler);

    default void defaultProcess(RequestHandler handler) {
        handler.start();
    }
}
