package executor_case;

import java.util.concurrent.Executor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/6/20
 * @Time: 20:04
 * @Description:
 * @version: 1.0.0
 */
public class DirectExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}