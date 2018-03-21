package command.indiv.example;

/**
 * 命令者注入了一个命令？命令者的行为通过命令来体现，和命令接收者没有任何关系，我只负责发出命令，
 * 命令由谁执行我不在乎，我只在乎发出命令，在这里，我也没有对执行结果进行处理，命令者之需要注入命令就可以了，或者说命令者依赖命令
 * 命令本身来控制执行者，命令依赖执行者，而执行者却毫不知情，OMG，真是神奇的设定，设计者为了解耦所做出来的设计真是令人惊叹
 *
 * 有点奇怪和小意思。
 */

public class Invoker {
    private Command command;

    /**
     * 有参数限定的调用者，我可以用静态方法来传经对象吗？如果我这样做了，我有什么好处吗？
     *
     * @param command 命令对象
     */
    public Invoker(Command command) {
        this.command = command;
    }

    public void sendCommand() {
        System.out.println("Invoker sent command");
        command.exe();
    }

    public Command getCommand() {
        return command;
    }

    /**
     * 为什么会设置setter 访问者呢？因为我想可以改变command，至于这样做的后果，我想应该没什么后果吧，会改变命令吗？这就是我想要的啊
     *
     * @return 调用者本身
     */
    public Invoker setCommand(Command command) {
        this.command = command;
        return this;
    }
}
