package allinpay.config;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 通联支付平台认证信息
 * @Date: Created at 10:42 2018/10/30.
 */
@Setter
@Getter
public class AllinpayConfig {
    //开放平台api网关
    private String endpoint;

    // 合作身份者ID，以2088开头由16位纯数字组成的字符串
    private String partner;
    // 商户的私钥
    private String key;


    private String proxy;
    private Integer socketTimeout;
    private Integer connectTimeout;

    public boolean hasProxy() {
        return !StringUtils.isEmpty(proxy);
    }

    public void setProxy(final String host, int port) {
        Preconditions.checkArgument(!StringUtils.isEmpty(host), "host must not empty");
        Preconditions.checkArgument(port > 0, "port must not be less than zero");
        this.proxy = host + ":" + port;
    }

    public String getProxy() {
        return proxy;
    }
}