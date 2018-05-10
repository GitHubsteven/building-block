package lambda.command;

import java.util.ArrayList;
import java.util.List;

/**
 * macro operation
 * <p>
 * Created by rongbin.xie on 2018/3/21.
 */
public class Macro {
    private final List<Action> actions;

    public Macro() {
        this.actions = new ArrayList<>();
    }

    /**
     * add action
     *
     * @param action action
     * @return add result
     */
    boolean record(Action action) {
        return this.actions.add(action);
    }

    void run(){
        actions.forEach(action -> action.operate(1L));
    }
}
