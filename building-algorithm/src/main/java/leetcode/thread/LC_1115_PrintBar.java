package leetcode.thread;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/11/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class LC_1115_PrintBar {
    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(10);

        fooBar.foo(() -> {
            System.out.print("foo");
        });

        fooBar.bar(() -> {
            System.out.print("bar");
        });
    }
}
