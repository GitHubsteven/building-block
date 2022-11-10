package com.variety.shop.indi.thread;

/**
 * Created by rongbin.xie on 2017/11/23.
 */
public class BusinessServiceTest {
    public static void main(String[] args) {
        BusinessService service = new BusinessService();
        Thread service1 = new ServiceThread(service);
        Thread service2 = new ServiceThread(service);
        Thread service3 = new ServiceThread(service);

        service1.start();
        service2.start();
        service3.start();
//         TODO: 2017/11/23 解决如下问题 important
//        问题： 为什么在threadLocal中，<T>容器初始化过程中使用了单例模式，仍然会有线程安全呢？
    }

    public static class ServiceThread extends Thread {
        private BusinessService service;

        ServiceThread(BusinessService service) {
            this.service = service;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                String threadName = Thread.currentThread().getName();
                service.functionSet(threadName, i);
                System.out.println("Thread [" + threadName + "]" + "Get data:" + service.continueFunctionSet());
            }
        }
    }
}
