package command.indiv.example;

/**
 * command为什么要有接口呢？只是定义了一个行为而已，如果只是为了定义一个行为的话，这样做会显得画蛇添足吗？
 */
public interface Command {
    void exe();
}
