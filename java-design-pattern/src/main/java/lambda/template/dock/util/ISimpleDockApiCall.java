package lambda.template.dock.util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description: api调用回调类
 * @Date: Created at 17:24 2018/5/8.
 */
public interface ISimpleDockApiCall {
    /**
     * 调用api 返回
     *
     * @param apiRealize api实现
     * @return 期待返回一个可以调用回调函数的对象，以方便调用回调函数
     */
    <T, R> ISimpleDockApiCall callApi(Function<T, R> apiRealize);

    /**
     * 成功的回调函数，消费api的返回结果
     *
     * @param sConsumer 成功的回调函数
     * @param <R>       api调用后返回的类型
     * @return 返回回调类对象
     */
    <R> ISimpleDockApiCall success(Consumer<R> sConsumer);

    /**
     * 成功的回调函数，消费api的返回结果
     *
     * @param fConsumer 成功的回调函数
     * @param <R>       api调用后返回的类型
     * @return 返回回调类对象
     */
    <R> ISimpleDockApiCall failed(Consumer<R> fConsumer);

    /**
     * 对api调用的结果是否成功的自定义
     *
     * @param isSuccess 判断标准
     * @return 是否调用成功
     */
    ISimpleDockApiCall isCallSuccess(Supplier<Boolean> isSuccess);

    /**
     * 运行整个api调用流程
     *
     * @param supplier 原始数据生产者
     * @param <T>      原始数据类型
     */
    <T> ISimpleDockApiCall execute(Supplier<T> supplier);
}
