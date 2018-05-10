package tranditional.command.indiv.example;

/**
 * 命令的实现的同时也制定了命令的执行者，这很好，可以避免执行者为空产生的运行时错误，但是，如果我想换个执行者怎么办呢？
 * 如果我增加了执行者的访问者会怎么样呢？
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
