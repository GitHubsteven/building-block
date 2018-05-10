package lambda.template.dock.util;

import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 17:05 2018/5/8.
 */
@Service
public interface IDockApiCall {
    /**
     * 调用api 返回
     *
     * @return 期待返回一个可以调用回调函数的对象，以方便调用回调函数
     */
    <T, R> DockApiCallBack callApi(Function<T, R> apiRealize);

    interface DockApiCallBack {
        /**
         * 成功的回调函数，消费api的返回结果
         *
         * @param sConsumer 成功的回调函数
         * @param <R>       api调用后返回的类型
         * @return 返回回调类对象
         */
        <R> DockApiCallBack sucess(Consumer<R> sConsumer);

        /**
         * 成功的回调函数，消费api的返回结果
         *
         * @param fConsumer 成功的回调函数
         * @param <R>       api调用后返回的类型
         * @return 返回回调类对象
         */
        <R> DockApiCallBack failed(Consumer<R> fConsumer);
    }
}
