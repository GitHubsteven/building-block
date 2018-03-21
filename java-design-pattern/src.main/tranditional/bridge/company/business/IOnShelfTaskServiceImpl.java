package tranditional.bridge.company.business;

public class IOnShelfTaskServiceImpl implements ITaskService {
    @Override
    public void createTask() {
        System.out.println("server is creating onShelf task ...");
    }
}
