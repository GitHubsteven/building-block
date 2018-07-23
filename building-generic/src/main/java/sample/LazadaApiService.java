package sample;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface LazadaApiService<T> {

    /**
     * 这里不支持发送mq
     *
     * @param f api调用接口
     */
    <R> ApiCallback<R> api(Function<T, R> f);

    interface ApiCallback<R> {

        /**
         * 请不要在这里发送mq
         *
         * @param c 成功结果消费者
         */
        ApiCallback<R> success(Consumer<R> c);

        ApiCallback<R> failure(Consumer<Exception> c);

        /**
         * mq 不是放在事务中处理，请注意，如果不是一定要发，请不要在这里实现
         *
         * @param mqConsumer mq发送者
         */
        ApiCallback<R> sendMq(Runnable mqConsumer);

        /**
         * 默认放在事务中运行
         */
        void execute();

        /**
         * 是否在事务中运行
         *
         * @param inTran 是否在事务中运行
         */
        void execute(Supplier<Boolean> inTran);
    }

    static <T> LazadaApiService<T> of(Supplier<T> s) {
        return new LazadaApiService<T>() {

            @Override
            public <R> ApiCallback<R> api(Function<T, R> f) {
                return new ApiCallback<R>() {

                    private Consumer<R> sConsumer = c -> {
                    };
                    private Consumer<Exception> fConsumer = c -> {
                    };
                    private Runnable mqConsumer = null;

                    @Override
                    public ApiCallback<R> success(Consumer<R> c) {
                        sConsumer = c;
                        return this;
                    }

                    @Override
                    public ApiCallback<R> failure(Consumer<Exception> c) {
                        fConsumer = c;
                        return this;
                    }

                    @Override
                    public ApiCallback<R> sendMq(Runnable mqConsumer) {
                        this.mqConsumer = mqConsumer;
                        return this;
                    }

                    @Override
                    public void execute() {
                        execute(() -> true);
                    }

                    @Override
                    public void execute(Supplier<Boolean> inTran) {
                        try {
                            T data = s.get();
                            if (data == null) {
                                throw new NullPointerException();
                            } else {
                                Boolean isInTran = inTran.get();
                                if (isInTran != null && isInTran) {
                                    //在事务中运行
                                    // TODO: 2018/7/20 实现在事务中运行
                                } else {
                                    //不在事务中运行
                                    sConsumer.accept(f.apply(data));
                                }
                                //执行mq
                                if (null != mqConsumer) {
                                    mqConsumer.run();
                                }
                            }
                        } catch (Exception e) {
                            fConsumer.accept(e);
                        }
                    }

                };
            }
        };
    }

}
