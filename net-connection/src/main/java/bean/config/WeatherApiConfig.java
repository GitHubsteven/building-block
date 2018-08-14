package bean.config;

import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/14
 * @Time: 11:29
 * @Description:
 * @version: 1.0.0
 */
public class WeatherApiConfig implements Serializable {
    private Map<String,Object> params;

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

}