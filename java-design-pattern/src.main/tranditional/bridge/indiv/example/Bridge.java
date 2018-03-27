package tranditional.bridge.indiv.example;

/**
 * tranditional.composite，通过setter方式来设置成员变量
 */
public abstract class Bridge {
    private IService service;

    public IService getService() {
        return service;
    }

    public Bridge setService(IService service) {
        this.service = service;
        return this;
    }

    public void operate(){
        this.service.operate();
    }
}
