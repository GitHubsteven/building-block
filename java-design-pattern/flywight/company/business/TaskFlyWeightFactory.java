package flywight.company.business;

import bean.business.JavaDevDirEnum;
import bridge.company.business.ITaskService;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个享元模式并不是很实用
 */
public class TaskFlyWeightFactory {

    private final static Map<JavaDevDirEnum.TASK_TYPE,ITaskService> taskServices = new HashMap<>();

    TaskFlyWeightFactory(JavaDevDirEnum.TASK_TYPE task_type,ITaskService service){
        taskServices.put(task_type,service);
    }

    public static ITaskService getService(JavaDevDirEnum.TASK_TYPE task_type){
        return taskServices.get(task_type);
    }


}
