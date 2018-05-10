package lambda.template.dock.util;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description: 简单对接接口调用实现模板
 * @Date: Created at 17:30 2018/5/8.
 */
public class BaseSimpleDockApiCall implements ISimpleDockApiCall {
    // TODO: 2018/5/8 如何解决这里的类型定义问题

    private Function apiRealize;
    private Consumer sConsumer;
    private Consumer fConsumer;
    private Supplier<Boolean> isSuccess;

    /**
     * 调用api 返回
     *
     * @param apiRealize api实现
     * @return 期待返回一个可以调用回调函数的对象，以方便调用回调函数
     */
    @Override
    public <T, R> ISimpleDockApiCall callApi(Function<T, R> apiRealize) {
        this.apiRealize = apiRealize;
        return this;
    }

    /**
     * 成功的回调函数，消费api的返回结果
     *
     * @param sConsumer 成功的回调函数
     * @return 返回回调类对象
     */
    @Override
    public <R> ISimpleDockApiCall success(Consumer<R> sConsumer) {
        this.sConsumer = sConsumer;
        return this;
    }

    /**
     * 成功的回调函数，消费api的返回结果
     *
     * @param fConsumer 成功的回调函数
     * @return 返回回调类对象
     */
    @Override
    public <R> ISimpleDockApiCall failed(Consumer<R> fConsumer) {
        this.fConsumer = fConsumer;
        return this;
    }

    /**
     * 对api调用的结果是否成功的自定义
     *
     * @param isSuccess 判断标准
     * @return 是否调用成功
     */
    @Override
    public ISimpleDockApiCall isCallSuccess(Supplier<Boolean> isSuccess) {
        this.isSuccess = isSuccess;
        return this;
    }

    /**
     * 运行整个api调用流程
     *
     * @param supplier 原始数据生产者
     */
    @Override
    public <T> ISimpleDockApiCall execute(Supplier<T> supplier) {
        T primitive = supplier.get();
        Object resp = this.apiRealize.apply(primitive);
        Boolean callSuccess = this.isSuccess.get();
        if (callSuccess) {
            sConsumer.accept(resp);
        } else {
            fConsumer.accept(resp);
        }
        return this;
    }
}
