package observer.indiv.example;

public class ObserverImpl1 implements Observer {

    @Override
    public void operate() {
        System.out.println("Observer1 has received the notify, and is making changes ...");
    }
}
