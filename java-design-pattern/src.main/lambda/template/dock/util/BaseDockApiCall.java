package lambda.template.dock.util;

import org.springframework.cglib.core.internal.Function;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 17:07 2018/5/8.
 */
public class BaseDockApiCall implements IDockApiCall {

    /**
     * 调用api 返回
     *
     * @param apiRealize api 的实现
     * @return 期待返回一个可以调用回调函数的对象，以方便调用回调函数
     */
    @Override
    public <T, R> DockApiCallBack callApi(Function<T, R> apiRealize) {
        return null;
    }
}
