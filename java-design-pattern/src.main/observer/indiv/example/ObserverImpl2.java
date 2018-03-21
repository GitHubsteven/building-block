package observer.indiv.example;

public class ObserverImpl2 implements Observer{
    @Override
    public void operate() {
        System.out.println("observer2 has received the notify, and is making changes ...");
    }
}
