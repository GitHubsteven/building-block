package lambda.template.dock.workflow;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description: 推送订单流程
 * @Date: Created at 19:01 2018/5/8.
 */
public abstract class PushOrderWorkFlowTemp<T,R> implements IWorkFlow {

    @Override
    public List<T> listData(Map param) {
        return null;
    }

    public abstract void pushOneOrder(T order);

    abstract R buildTargetOrder(Supplier<T> supplier);

    @Override
    public void work() {

    }
}
