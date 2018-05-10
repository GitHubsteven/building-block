package tranditional.observer.indiv.example;

public class Environment {
    public static void main(String[] args) {
        Subject subject = new MySubject();
        Observer observer1 =  new ObserverImpl1();
        Observer observer2 = new ObserverImpl2();

        subject.add(observer1);
        subject.add(observer2);
        subject.operation();
    }
}
