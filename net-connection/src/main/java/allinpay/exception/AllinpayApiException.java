package allinpay.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/9/19
 * @Time: 11:31
 * @Description: 通联支付平台对接异常定义
 * @version: 1.0.0
 */
public class AllinpayApiException extends RuntimeException {
    public AllinpayApiException() {
    }

    public AllinpayApiException(final String message) {
        super(message);
    }

    public AllinpayApiException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AllinpayApiException(final Throwable cause) {
        super(cause);
    }

    public AllinpayApiException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}