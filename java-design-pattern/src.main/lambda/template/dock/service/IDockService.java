package lambda.template.dock.service;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description: service的一些一些定义
 * @Date: Created at 17:03 2018/5/8.
 */
public interface IDockService<T> {
    /**
     * 设置服务
     *
     * @param service 对接服务
     */
     void setService(T service);

    /**
     * 保证service的存在
     */
    void confirmService();
}
