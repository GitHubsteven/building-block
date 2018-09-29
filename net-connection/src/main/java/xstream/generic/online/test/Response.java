package xstream.generic.online.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Time: 9:40
 * @Description:
 * @version: 1.0.0
 */
@XStreamAlias("RESPONSE")
public class Response<T extends RETINFO> {
    @XStreamAlias("ERRORINFO")
    private ErrorInfo errorInfo;
    @XStreamAlias("RETINFO")
    private T retInfo;

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public T getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(T retInfo) {
        this.retInfo = retInfo;
    }
}