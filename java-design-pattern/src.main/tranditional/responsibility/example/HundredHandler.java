package tranditional.responsibility.example;

import tranditional.bean.common.DesignPatRequest;

public class HundredHandler extends AbstractHandler {
    @Override
    public Handler process(DesignPatRequest request) {
        if (request.getPay() < 1000 && request.getPay() >= 100) {
            System.out.println("handler(pay in (100,1000)) process request successfully, stop the request here!");
            return null;
        } else {
            System.out.println("failed to process the request, pass the request to the successor!");
            Handler successor = getSuccessor();
            return successor == null ? null : successor.process(request);
        }
    }
}
