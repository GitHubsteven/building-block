package allinpay.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 请求参数基础类
 * @Date: Created at 10:19 2018/10/30.
 */
@Setter
@Getter
public abstract class BaseRequest implements Serializable {
    @JsonIgnore
    private String service;

    public BaseRequest(String service) {
        this.service = service;
    }
}