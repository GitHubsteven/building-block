package tranditional.observer.indiv.example;

import java.util.Vector;

public  abstract class AbstractSubject implements Subject{
    private Vector<Observer> observers = new Vector<>();

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void del(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(observer -> observer.operate());
    }

}
