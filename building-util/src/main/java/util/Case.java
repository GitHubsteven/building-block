package util;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author: jet.xie
 * @Date: 2018/7/20
 * @Time: 14:56
 * @version: 1.0.0
 * @Description: 需求是什么：
 * 根据条件key，来实现如下功能
 * 1：执行方法，返回值为空
 * 2：执行方法，返回值不为空，默认值可以设置，也可以抛出异常
 * 3：参数可以传，也可以不传
 * 4：链式开发
 * <p>
 * 分析：
 * key的类型 ------> 在class类初始化中指定<K></>
 * 链式开发：增加子类作为辅助类
 * 参数可以为空：
 * <p>
 * 执行方法：---->作为参数传递，怎么调用
 */

public class Case<T> {
    private final T _value;
    private boolean matched = false;

    private Case(T value) {
        this._value = value;
    }

    public static <T> Case<T> of(T value) {
        //noinspection unchecked
        return new Case(value);
    }

    private <R> Case<T>.CaseWithContext<R> contextOf(R value) {
        //noinspection unchecked
        return new Case.CaseWithContext(value);
    }

    private <R> Case<T>.CaseWithContext<R> emptyContext() {
        //noinspection unchecked
        return new Case.CaseWithContext(null);
    }

    public <R> Case<T>.CaseWithContext<R> getWhen(Object value, R result) {
        if (!this.matched && this._value.equals(value)) {
            this.matched = true;
            return this.contextOf(result);
        } else {
            return this.emptyContext();
        }
    }

    public <R> Case<T>.CaseWithContext<R> getWhen(Object value, Function<T, R> function) {
        if (!this.matched && this._value.equals(value)) {
            this.matched = true;
            return this.contextOf(function.apply(this._value));
        } else {
            return this.emptyContext();
        }
    }

    public Case<T> when(Object value, Runnable runnable) {
        if (!this.matched && this._value.equals(value)) {
            this.matched = true;
            runnable.run();
        }

        return this;
    }

    public Case<T> when(Object value, Consumer<T> consumer) {
        if (!this.matched && this._value.equals(value)) {
            this.matched = true;
            consumer.accept(this._value);
        }

        return this;
    }

    public <R> Case<T>.CaseWithContext<R> orGetDefault(R result) {
        if (!this.matched) {
            this.matched = true;
            return this.contextOf(result);
        } else {
            return this.emptyContext();
        }
    }

    public <R> Case<T>.CaseWithContext<R> orGetDefault(Function<T, R> function) {
        if (!this.matched) {
            this.matched = true;
            return this.contextOf(function.apply(this._value));
        } else {
            return this.emptyContext();
        }
    }

    public Case<T> orDefault(Runnable runnable) {
        if (!this.matched) {
            this.matched = true;
            runnable.run();
        }

        return this;
    }

    public Case<T> orDefault(Consumer<T> consumer) {
        if (!this.matched) {
            this.matched = true;
            consumer.accept(this._value);
        }

        return this;
    }

    public <O> Case<T> when(Class<O> clazz, Consumer<O> consumer) {
        if (!this.matched && clazz.isInstance(this._value)) {
            this.matched = true;
            //noinspection unchecked
            consumer.accept((O) this._value);
        }

        return this;
    }

    public <O> Case<T> when(Class<O> clazz, Runnable runnable) {
        if (!this.matched && clazz.isInstance(this._value)) {
            this.matched = true;
            runnable.run();
        }

        return this;
    }

    public <O, R> Case<T>.CaseWithContext<R> getWhen(Class<O> clazz, Function<O, R> function) {
        if (!this.matched && clazz.isInstance(this._value)) {
            this.matched = true;
            //noinspection unchecked
            return this.contextOf(function.apply((O) this._value));
        } else {
            return this.emptyContext();
        }
    }

    public <O, R> Case<T>.CaseWithContext<R> getWhen(Class<O> clazz, R result) {
        if (!this.matched && clazz.isInstance(this._value)) {
            this.matched = true;
            return this.contextOf(result);
        } else {
            return this.emptyContext();
        }
    }

    public class CaseWithContext<R> {
        private R result;

        CaseWithContext(R result) {
            this.result = result;
        }

        public Case<T>.CaseWithContext<R> getWhen(Object value, R result) {
            if (!Case.this.matched && Case.this._value.equals(value)) {
                Case.this.matched = true;
                this.result = result;
            }

            return this;
        }

        public Case<T>.CaseWithContext<R> getWhen(Object value, Function<T, R> function) {
            if (!Case.this.matched && Case.this._value.equals(value)) {
                Case.this.matched = true;
                this.result = function.apply(Case.this._value);
            }

            return this;
        }

        public Case<T>.CaseWithContext<R> when(Object value, Runnable runnable) {
            Case.this.when(value, runnable);
            return this;
        }

        public Case<T>.CaseWithContext<R> when(Object value, Consumer<T> consumer) {
            Case.this.when(value, consumer);
            return this;
        }

        public Case<T>.CaseWithContext<R> orGetDefault(R result) {
            if (!Case.this.matched) {
                Case.this.matched = true;
                this.result = result;
            }

            return this;
        }

        public Case<T>.CaseWithContext<R> orGetDefault(Function<T, R> function) {
            if (!Case.this.matched) {
                Case.this.matched = true;
                this.result = function.apply(Case.this._value);
            }

            return this;
        }

        public Case<T>.CaseWithContext<R> orDefault(Runnable runnable) {
            Case.this.orDefault(runnable);
            return this;
        }

        public Case<T>.CaseWithContext<R> orDefault(Consumer<T> consumer) {
            Case.this.orDefault(consumer);
            return this;
        }

        public <O> Case<T>.CaseWithContext<R> when(Class<O> clazz, Consumer<O> consumer) {
            Case.this.when(clazz, consumer);
            return this;
        }

        public <O> Case<T>.CaseWithContext<R> when(Class<O> clazz, Runnable runnable) {
            Case.this.when(clazz, runnable);
            return this;
        }

        public <O> Case<T>.CaseWithContext<R> getWhen(Class<O> clazz, R result) {
            if (!Case.this.matched && clazz.isInstance(Case.this._value)) {
                Case.this.matched = true;
                this.result = result;
            }

            return this;
        }

        public <O> Case<T>.CaseWithContext<R> getWhen(Class<O> clazz, Function<O, R> function) {
            if (!Case.this.matched && clazz.isInstance(Case.this._value)) {
                Case.this.matched = true;
                //noinspection unchecked
                this.result = function.apply((O) Case.this._value);
            }

            return this;
        }

        public Optional<R> getResult() {
            return Optional.ofNullable(this.result);
        }
    }
}