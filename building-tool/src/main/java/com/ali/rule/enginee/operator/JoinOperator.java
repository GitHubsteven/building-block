/**
 * @author: asx
 * @date: 2023/8/8
 * @descrition:
 */
package com.ali.rule.enginee.operator;

import com.ql.util.express.Operator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: asx
 * @date: 2023/8/8
 * @descrition:
 */
public class JoinOperator extends Operator {
    public Object executeInner(Object[] list) throws Exception {
        Object opdata1 = list[0];
        Object opdata2 = list[1];
        if (opdata1 instanceof List) {
            ((List)opdata1).add(opdata2);
            return opdata1;
        } else {
            List result = new ArrayList();
            for (Object opdata : list) {
                result.add(opdata);
            }
            return result;
        }
    }
}
