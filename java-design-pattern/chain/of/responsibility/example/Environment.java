package chain.of.responsibility.example;

import bean.common.DesignPatRequest;

public class Environment {
    public static void main(String[] args) {
        DesignPatRequest request = new DesignPatRequest();
        request.setPay(5555);
        TenThouSandHandler tenThouSandHandler = new TenThouSandHandler();
        ThousandHandler thousandHandler = new ThousandHandler();
        thousandHandler.setSuccessor(tenThouSandHandler);
        HundredHandler hundredHandler = new HundredHandler();
        hundredHandler.setSuccessor(thousandHandler);

        hundredHandler.process(request);
    }
}
