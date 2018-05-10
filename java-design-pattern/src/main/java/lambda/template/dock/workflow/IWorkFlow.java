package lambda.template.dock.workflow;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description: 工作流
 * @Date: Created at 17:03 2018/5/8.
 */
public interface IWorkFlow<T> {
    /**
     * 获取原始数据
     *
     * @param param 参数
     * @return 原始数据集合
     */
    List<T> listData(Map param);


    void work();
}
