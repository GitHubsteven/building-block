package lambda.template.dock.service;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 19:27 2018/5/8.
 */
public class BaseDockService<T> implements IDockService {
    private T service;

    /**
     * 设置服务
     *
     * @param service 对接服务
     */
    public void setService(Object service) {

    }

    /**
     * 保证service的存在
     */
    public void confirmService() {

    }
}
