package data.structure.book.tree.store;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 二叉树运行异常
 * @Date: Created at 11:17 2019/3/11.
 */
public class BinException extends RuntimeException {
    public BinException() {
    }

    public BinException(String message) {
        super(message);
    }

    public BinException(String message, Throwable cause) {
        super(message, cause);
    }

    public BinException(Throwable cause) {
        super(cause);
    }

    public BinException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}