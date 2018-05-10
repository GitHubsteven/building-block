package tranditional.observer.indiv.example;

public interface Subject {
    void add(Observer observer);

    void del(Observer observer);

    void notifyObservers();

    void operation();
}
