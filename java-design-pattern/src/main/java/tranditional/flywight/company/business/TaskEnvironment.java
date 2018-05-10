package tranditional.flywight.company.business;

import tranditional.bridge.company.business.IOnShelfTaskServiceImpl;
import tranditional.bridge.company.business.ITaskService;

public class TaskEnvironment {
    public static void main(String[] args) {
        ITaskService onShelfTaskService = new IOnShelfTaskServiceImpl();
    }
}
