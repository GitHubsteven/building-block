package tranditional.bridge.company.business;

/**
 * client
 */
public class TaskCtrl {
    private ITaskService iTaskService;

    public TaskCtrl(ITaskService iTaskService) {
        this.iTaskService = iTaskService;
    }

    public void createTask(){
        iTaskService.createTask();
    }
}
