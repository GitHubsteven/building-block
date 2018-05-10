package tranditional.bean.common;

import java.io.Serializable;

/**
 * common request tranditional.bean as param designed for test.
 */
public class DesignPatRequest implements Serializable {
    private String name;
    private String ip;
    private String url;
    private String context;
    /*付款金额*/
    private Integer pay;

    public String getName() {
        return name;
    }

    public DesignPatRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public DesignPatRequest setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DesignPatRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getContext() {
        return context;
    }

    public DesignPatRequest setContext(String context) {
        this.context = context;
        return this;
    }

    public Integer getPay() {
        return pay;
    }

    public DesignPatRequest setPay(Integer pay) {
        this.pay = pay;
        return this;
    }
}
