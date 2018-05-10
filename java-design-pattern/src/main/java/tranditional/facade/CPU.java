package tranditional.facade;

import java.io.Serializable;

public class CPU implements Serializable {
    public void startUp(){
        System.out.println("CPU is starting up ...");
    }

    public void shutDown(){
        System.out.println("CPU is shutting down ...");
    }
}
