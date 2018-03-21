package command.indiv.lamda;

/**
 * action define interface
 *
 * Created by rongbin.xie on 2018/3/21.
 */
@FunctionalInterface
public interface Action {
    void  operate(Long id);
}
