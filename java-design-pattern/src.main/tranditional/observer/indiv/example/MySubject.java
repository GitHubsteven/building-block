package tranditional.observer.indiv.example;

public class MySubject extends AbstractSubject {

    @Override
    public void operation() {
        System.out.println("subject status is changed, and notify the observers ...");
        notifyObservers();
    }
}
