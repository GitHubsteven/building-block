package flywight.company.business;

import bridge.company.business.IOnShelfTaskServiceImpl;
import bridge.company.business.ITaskService;

public class TaskEnvironment {
    public static void main(String[] args) {
        ITaskService onShelfTaskService = new IOnShelfTaskServiceImpl();
    }
}
