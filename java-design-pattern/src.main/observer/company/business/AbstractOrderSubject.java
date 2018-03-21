package observer.company.business;

import java.util.Vector;

public abstract class AbstractOrderSubject implements  IOrderSubject{
    private Vector<OrderObserver> observers = new Vector<>();
    @Override
    public void addObserver() {

    }

    @Override
    public void delObserver() {

    }

    @Override
    public void notifyObservers() {

    }
}
