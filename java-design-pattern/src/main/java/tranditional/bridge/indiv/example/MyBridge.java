package tranditional.bridge.indiv.example;

/**
 *
 */
public class MyBridge extends Bridge {
    @Override
    public void operate() {
        super.getService().operate();
    }
}
