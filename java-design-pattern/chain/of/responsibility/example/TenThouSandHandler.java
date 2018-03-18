package chain.of.responsibility.example;

import bean.common.DesignPatRequest;

public class TenThouSandHandler extends AbstractHandler {
    @Override
    public Handler process(DesignPatRequest request) {
        if (request.getPay() >= 10000) {
            System.out.println("handle request successfully(more than 10000), end the request");
            return null;
        } else {
            System.out.println("handle request failed, pass the request to the successor");
            Handler successor = getSuccessor();
            return successor == null ? null : successor.process(request);
        }
    }
}
