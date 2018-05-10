package lambda.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author asaland.xie
 * @Description: subject whose status' change will inform all observers
 * @Date: Created at 21:26 2018/3/21.
 */
public class Moon {
    private final List<LandingObserver> observers;

    public Moon() {
        this.observers = new ArrayList<>();
    }

    public boolean addObserver(LandingObserver observer) {
        return this.observers.add(observer);
    }

    /**
     * 登陆
     *
     * @param name 登陆者
     */
    public void land(String name) {
        this.observers.forEach(it -> it.observeLanding(name));
    }
}
