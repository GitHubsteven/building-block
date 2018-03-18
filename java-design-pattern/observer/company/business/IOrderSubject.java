package observer.company.business;

public interface IOrderSubject {
    void addObserver();

    void delObserver();

    void notifyObservers();

    void operate(Long id);
}
