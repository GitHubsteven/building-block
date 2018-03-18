package bean.common;

import java.io.Serializable;

/**
 * common response for common request
 */
public class DesignPatResponse implements Serializable {
    private String ip;
    private String data;
    private String responseCode;

    public String getIp() {
        return ip;
    }

    public DesignPatResponse setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getData() {
        return data;
    }

    public DesignPatResponse setData(String data) {
        this.data = data;
        return this;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public DesignPatResponse setResponseCode(String responseCode) {
        this.responseCode = responseCode;
        return this;
    }
}
