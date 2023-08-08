/**
 * @author: asx
 * @date: 2023/8/8
 * @descrition:
 */
package com.ali.rule.enginee;

import com.ali.rule.enginee.operator.JoinOperator;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

/**
 * @author: asx
 * @date: 2023/8/8
 * @descrition:
 */
public class QLExpressDemo {
    public static void main(String[] args) throws Exception {
        demo1();

    }
    public static void demo2() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.addOperator("join", new JoinOperator());
        Object r = runner.execute("1 join 2 join 3", context, null, false, false);
        System.out.println(r); // 返回结果 [1, 2, 3]
    }


    private static void demo1() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("a", 1);
        context.put("b", 2);
        context.put("c", 3);
        String express = "a + b * c";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);
    }
}
